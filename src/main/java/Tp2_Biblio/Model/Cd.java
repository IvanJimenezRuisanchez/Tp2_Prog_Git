package Tp2_Biblio.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Cd extends Document {
    private String duration;
    private String type;

    public Cd(String titre, int anneePub, String auteur, long nbrExemplaire, String duration, String type) {
        super(titre, anneePub, auteur, nbrExemplaire);
        this.duration = duration;
        this.type = type;
    }
}
