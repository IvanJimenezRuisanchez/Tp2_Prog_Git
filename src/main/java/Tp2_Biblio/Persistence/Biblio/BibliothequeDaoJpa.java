package Tp2_Biblio.Persistence.Biblio;

import Tp2_Biblio.Model.Document;
import Tp2_Biblio.Model.Empreunt;
import Tp2_Biblio.Model.Livre;
import Tp2_Biblio.Model.Utilisateur;

import java.util.List;


public interface BibliothequeDaoJpa {
    <T> void save(T t);
    <T> void merge(T t);

    Utilisateur saveUser(Utilisateur user);

    Document saveDocument(Document document);

    List<Livre>  recherchePar(String critereRecherche, String data);

    Empreunt empreunter(long idUser, Document document);

    List<Empreunt>getListEmpreunts(long idUser);
}
