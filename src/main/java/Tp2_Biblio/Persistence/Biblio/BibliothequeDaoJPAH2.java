package Tp2_Biblio.Persistence.Biblio;

import Tp2_Biblio.Model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BibliothequeDaoJPAH2 implements BibliothequeDaoJpa {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tp2");

    @Override
    public Utilisateur saveUser(Utilisateur user) {
        save(user);
        return user;
    }

    public <T> void save(T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }

}
