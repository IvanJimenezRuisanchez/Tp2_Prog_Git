package Tp2_Biblio.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Client extends Utilisateur {

    public Client(String firstName, String lastName, String address, String phoneNumber, String email) {
        super(firstName, lastName, address, phoneNumber, email);
    }
}
