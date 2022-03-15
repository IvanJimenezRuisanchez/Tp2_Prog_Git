package Tp2_Biblio.Persistence.Biblio;

import Tp2_Biblio.Model.*;

import javax.persistence.*;
import javax.print.DocFlavor;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BibliothequeDaoJPAH2 implements BibliothequeDaoJpa {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tp2");

    @Override
    public Utilisateur saveUser(Utilisateur user) {
        save(user);
        return user;
    }

    @Override
    public Document saveDocument(Document document) {
        save(document);
        return document;
    }

    @Override
    public List<Livre> recherchePar(String critereRecherche, String data) {
        List<Livre> livres;

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = getLivre(em,critereRecherche,data);
        em.getTransaction().commit();
        livres =query.getResultList();

        em.close();
        return livres;
    }

    @Override
    public Empreunt empreunter(long idUser, Document document) {
        if(document.getNbrExemplaire() > 0) {
            Client client = getClientByID(idUser);
            LocalDate dateFin = getDateFin(document);

            Empreunt empreunt = new Empreunt(client, document, LocalDate.now(), dateFin, "Valide");

            client.addEmpreuntToClient(empreunt);
            empreunt.addClientResponsable(client);
            empreunt.addDocumentToEmpreunt(document);

            updateExemplaire(document.getIdDocument(),document.getNbrExemplaire()+1);

            save(empreunt);
            merge(client);
            return empreunt;
        }
        else {
            return null;
        }
    }

    @Override
    public List<Empreunt> getListEmpreunts(long idUser) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Empreunt> query = em.createQuery("SELECT e from Empreunt e Where e.client.id = :idUser "
                ,Empreunt.class).setParameter("idUser", idUser);
        List<Empreunt> empreunts = query.getResultList();
        em.close();
        return empreunts;
    }


    @Override
    public <T> void save(T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public <T> void merge(T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(t);

        em.getTransaction().commit();
        em.close();
    }

    private Client getClientByID(long id){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        return em.find(Client.class,id);
    }

    private void updateExemplaire(long id,long nbrExemplaires){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Document d set d.nbrExemplaire = :nbrExemplaires where :id = d.idDocument");
        query.setParameter("nbrExemplaires",nbrExemplaires);
        query.setParameter("id",id);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    private LocalDate getDateFin(Document document) {
        switch (document.getClass().getSimpleName().toUpperCase()){
            case "LIVRE":
                return LocalDate.now().plusDays(21);
            case "CD":
                return LocalDate.now().plusDays(14);
            case "DVD":
                return LocalDate.now().plusDays(7);
        }
        return null;
    }


    private TypedQuery<Livre> getLivre(EntityManager em ,String critereRecherche,String data){
        switch (critereRecherche.toUpperCase()){
            case "TITRE":
                return em.createQuery("SELECT l from Livre l WHERE upper(l.titre) like :data  ",Livre.class).setParameter("data",'%'+data.toUpperCase()+'%');
            case "AUTEUR":
                return em.createQuery("SELECT l from Livre l WHERE upper(l.auteur) = :data",Livre.class).setParameter("data", data.toUpperCase());
            case "CATEGORIE":
                return em.createQuery("SELECT l from Livre l WHERE upper(l.type) = :data",Livre.class).setParameter("data", data.toUpperCase());
            case "ANNEE":
                return em.createQuery("SELECT l from Livre l WHERE l.anneePublication = :data",Livre.class).setParameter("data", Integer.parseInt(data));
        }
        return null;
    }
}
