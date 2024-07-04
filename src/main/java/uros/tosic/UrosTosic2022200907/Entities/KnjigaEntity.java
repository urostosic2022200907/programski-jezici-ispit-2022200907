package uros.tosic.UrosTosic2022200907.Entities;
//veza izmedju baze podataka i servera
//entity sluzi kao tabela iz servera u javi
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Knjiga")
@Getter
@Setter
public class KnjigaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "cena")
    private int cena;

    @Column(name = "vreme_dodavanja")
    private LocalDateTime vremeDodavanja;

    @Column(name = "biblioteka_id")
    private Long bibliotekaId;

    public KnjigaEntity(Long id, String ime, int cena, Long bibliotekaId) {
        this.id = id;
        this.ime = ime;
        this.cena = cena;
        this.vremeDodavanja = LocalDateTime.now();
        this.bibliotekaId = bibliotekaId;
    }

    public KnjigaEntity(String ime, int cena, Long bibliotekaId) {
        this.ime = ime;
        this.cena = cena;
        this.vremeDodavanja = LocalDateTime.now();
        this.bibliotekaId = bibliotekaId;
    }

    public KnjigaEntity() {}
}
