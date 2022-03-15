package Tp2_Biblio.Service;


import Tp2_Biblio.Model.*;
import Tp2_Biblio.Persistence.Biblio.BibliothequeDaoJpa;

import java.time.LocalDate;

public class BibliothequeService {
    private BibliothequeDaoJpa bibliothequeDaoJpa;
    private Bibliotheque bibliotheque = new Bibliotheque("82 rue Des Champs", LocalDate.now());

    public BibliothequeService(BibliothequeDaoJpa bibliothequeDaoJpa){
        this.bibliothequeDaoJpa = bibliothequeDaoJpa;
        bibliothequeDaoJpa.save(bibliotheque);
    }

    public Utilisateur addUserToBliblio(String firstName, String lastName, String address, String phoneNumber, String email, LocalDate dateEmbauche, String role) {
        Utilisateur user = null;
        switch (role.toUpperCase()){
            case "GESTIONNAIRE":
                user = new Gestionnaire(firstName,lastName,address,phoneNumber,email,dateEmbauche);
                break;
            case "CLIENT":
                user = new Client(firstName,lastName,address,phoneNumber,email);
                break;
            case "PREPOSE":
                user = new Prepose(firstName,lastName,address,phoneNumber,email,dateEmbauche);
                break;
        }
        bibliotheque.addUser(user);
        user.setBiblio(bibliotheque);
        return bibliothequeDaoJpa.saveUser(user);
    }
}
