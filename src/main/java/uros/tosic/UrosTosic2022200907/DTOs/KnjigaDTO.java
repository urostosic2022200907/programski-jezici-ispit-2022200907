package uros.tosic.UrosTosic2022200907.DTOs;
//sluzi za prenosenje post requestova knjige i ovde ga cuva
public class KnjigaDTO {
    public String ime;
    public int cena;
    public Long bibliotekaId;

    public KnjigaDTO(String ime, int cena, Long bibliotekaId) {
        this.ime = ime;
        this.cena = cena;
        this.bibliotekaId = bibliotekaId;
    }
}
