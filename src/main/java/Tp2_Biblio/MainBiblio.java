package Tp2_Biblio;

import Tp2_Biblio.Persistence.Biblio.BibliothequeDaoJPAH2;
import Tp2_Biblio.Service.BibliothequeService;

import java.time.LocalDate;

public class MainBiblio {
    public static void main(String[] args) {
        BibliothequeService bibliothequeService = new BibliothequeService(new BibliothequeDaoJPAH2());

        bibliothequeService.addUserToBliblio("Ivan","Jimenez","8130 Rue Thomas",
                "438-924-8526","ivantest33@gmail.com", LocalDate.now(),"Gestionnaire");

        bibliothequeService.addUserToBliblio("Carlos","Martinez","30 Rue BTTTT",
                "438-678-4326","DWd234@gmail.com",null, "Client");

        bibliothequeService.addUserToBliblio("Robin","Makucv","4566 Rue St-Rio",
                "438-000-1000","robinKmam9@gmail.com", LocalDate.now(),"Prepose");


    }
}
