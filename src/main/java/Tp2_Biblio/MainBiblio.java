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

        bibliothequeService.addDocumentToBiblio("Les fables de la Fontaine", 1992,"Fontaine",
                "Frct","Fr-Medi-Cal","Roman",null,"Livre");

        bibliothequeService.addDocumentToBiblio("Fast and Furious: Tokyo Drift",2006,"Neal H. Moritz",null,
                null,"Action","1h 44m","CD");

        bibliothequeService.addDocumentToBiblio("Fast and Furious: Tokyo Drift",2006,"Neal H. Moritz",null,
                null,"Action","1h 44m","DVD");

    }
}
