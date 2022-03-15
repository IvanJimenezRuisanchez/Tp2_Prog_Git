package Tp2_Biblio.Persistence.Biblio;

import Tp2_Biblio.Model.Document;
import Tp2_Biblio.Model.Livre;
import Tp2_Biblio.Model.Utilisateur;

import java.util.List;


public interface BibliothequeDaoJpa {
    <T> void save(T t);
    Utilisateur saveUser(Utilisateur user);
    Document saveDocument(Document document);
    List<Livre>  recherchePar(String critereRecherche, String data);
}
