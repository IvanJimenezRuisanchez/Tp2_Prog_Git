package Tp2_Biblio.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bibliotheque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idBiblio;

    private String address;
    private LocalDate dateFundation;
    public Bibliotheque(String address, LocalDate dateFundation) {
        this.address = address;
        this.dateFundation = dateFundation;
    }

    @OneToMany
    List<Utilisateur> users = new ArrayList<>();

    public void addUser(Utilisateur user){
        users.add(user);
    }


}
