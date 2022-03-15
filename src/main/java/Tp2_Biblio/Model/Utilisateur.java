package Tp2_Biblio.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUser;

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;

    public Utilisateur(String firstName, String lastName, String address, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_biblio")
    @ToString.Exclude
    private Bibliotheque bibliotheque;

    public void setBiblio(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }
}
