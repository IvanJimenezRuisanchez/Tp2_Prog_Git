package Tp2_Biblio.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idDocument;

    private String titre;
    private int anneePublication;
    private String auteur;
    private long nbrExemplaire;

    public Document(String titre, int anneePub, String auteur, long nbrExemplaire) {
        this.titre = titre;
        this.anneePublication = anneePub;
        this.auteur = auteur;
        this.nbrExemplaire = nbrExemplaire;
    }


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_biblio_document")
    @ToString.Exclude
    private Bibliotheque bibliotheque;


    public void setBibliotheque(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }
}
