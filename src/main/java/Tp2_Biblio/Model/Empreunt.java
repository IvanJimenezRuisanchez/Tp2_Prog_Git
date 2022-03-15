package Tp2_Biblio.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Empreunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmpreunt;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String status;

    public Empreunt(Client user , Document document , LocalDate dateDebut, LocalDate dateFin, String status) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.status = status;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_document")
    private Document document;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_user")
    @ToString.Exclude
    private Client client;




    public void addDocumentToEmpreunt(Document document){ this.document = document; }

    public void addClientResponsable(Client client){ this.client = client; }



}
