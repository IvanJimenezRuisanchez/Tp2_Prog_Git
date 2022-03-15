package Tp2_Biblio;

import Tp2_Biblio.Model.Client;
import Tp2_Biblio.Model.Document;
import Tp2_Biblio.Model.Utilisateur;
import Tp2_Biblio.Persistence.Biblio.BibliothequeDaoJPAH2;
import Tp2_Biblio.Service.BibliothequeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainBiblio {
    public static void main(String[] args) {
        BibliothequeService bibliothequeService = new BibliothequeService(new BibliothequeDaoJPAH2());

        bibliothequeService.addUserToBliblio("Ivan","Jimenez","8130 Rue Thomas",
                "438-924-8526","ivantest33@gmail.com", LocalDate.now(),"Gestionnaire");

        Utilisateur client = bibliothequeService.addUserToBliblio("Carlos","Martinez","30 Rue BTTTT",
                "438-678-4326","DWd234@gmail.com",null, "Client");

        bibliothequeService.addUserToBliblio("Robin","Makucv","4566 Rue St-Rio",
                "438-000-1000","robinKmam9@gmail.com", LocalDate.now(),"Prepose");

        bibliothequeService.addDocumentToBiblio("Les fables de la Fontaine", 1992,"Fontaine",
                "Frct","Fr-Medi-Cal","Roman",null,3,"Livre");

        Document livre = bibliothequeService.addDocumentToBiblio("Les fables de la Fontaine2", 1952,"Fontaine",
                "Frct","Fr-Medi-Cal","Magazine",null,3,"Livre");

        Document cd = bibliothequeService.addDocumentToBiblio("Fast and Furious: Tokyo Drift",2006,"Neal H. Moritz",null,
                null,"Action","1h 44m",3,"CD");

        Document dvd = bibliothequeService.addDocumentToBiblio("Fast and Furious: Tokyo Drift",2006,"Neal H. Moritz",null,
                null,"Action","1h 44m",5,"DVD");


        bibliothequeService.findLivreBy("Titre","fables");
        bibliothequeService.findLivreBy("anNee","1952");
        bibliothequeService.findLivreBy("catEgorie","magazine");
        bibliothequeService.findLivreBy("auteUr", "Fontaine");

        bibliothequeService.empreunter(client.getIdUser(), livre);
        bibliothequeService.empreunter(client.getIdUser(),cd);
        bibliothequeService.empreunter(client.getIdUser(),dvd);


    }
}
