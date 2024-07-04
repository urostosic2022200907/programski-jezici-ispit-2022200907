package uros.tosic.UrosTosic2022200907.DTOs;
//sluzi za prenosenje post requestova biblioteke i ovde ga cuva
public class BibliotekaDTO {
    public String ime;
    public String adresa;

    public BibliotekaDTO(String ime, String adresa) {
        this.ime = ime;
        this.adresa = adresa;
    }
}
