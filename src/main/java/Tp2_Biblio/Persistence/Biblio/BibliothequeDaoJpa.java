package Tp2_Biblio.Persistence.Biblio;

import Tp2_Biblio.Model.Utilisateur;


public interface BibliothequeDaoJpa {
    <T> void save(T t);
    Utilisateur saveUser(Utilisateur user);
}
