package Tp2_Biblio.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Livre extends Document{

    private String editeur;
    private String maisonDePublication;
    private String type;

    public Livre(String titre, int anneePub, String auteur, long nbrExemplaire, String editeur, String maisonDePublication, String type) {
        super(titre, anneePub, auteur, nbrExemplaire);
        this.editeur = editeur;
        this.maisonDePublication = maisonDePublication;
        this.type = type;
    }
}
