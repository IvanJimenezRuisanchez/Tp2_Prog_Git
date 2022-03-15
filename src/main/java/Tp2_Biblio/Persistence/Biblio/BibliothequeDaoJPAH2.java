package Tp2_Biblio.Persistence.Biblio;

import Tp2_Biblio.Model.Document;
import Tp2_Biblio.Model.Livre;
import Tp2_Biblio.Model.Utilisateur;

import javax.persistence.*;
import java.util.List;

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
        Query query = get(em,critereRecherche,data);
        em.getTransaction().commit();
        livres =query.getResultList();
        em.close();
        return livres;
    }


    private TypedQuery<Livre> get(EntityManager em ,String critereRecherche,String data){
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


    public <T> void save(T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }

}
