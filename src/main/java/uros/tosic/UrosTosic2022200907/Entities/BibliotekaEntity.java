package uros.tosic.UrosTosic2022200907.Entities;
//veza izmedju baze podataka i servera
//entity sluzi kao tabela iz servera u javi
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Biblioteka")
@Getter
@Setter
public class BibliotekaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "adresa")
    private String adresa;

    public BibliotekaEntity(Long id, String ime, String adresa) {
        this.id = id;
        this.ime = ime;
        this.adresa = adresa;
    }

    public BibliotekaEntity(String ime, String adresa) {
        this.ime = ime;
        this.adresa = adresa;
    }

    public BibliotekaEntity() {}
}
