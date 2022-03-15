package Tp2_Biblio.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Dvd extends Document {
    private String duration;
    private String type;

    public Dvd(String titre, int anneePub, String auteur, long nbrExemplaire, String duration, String type) {
        super(titre, anneePub, auteur, nbrExemplaire);
        this.duration = duration;
        this.type = type;
    }
}
