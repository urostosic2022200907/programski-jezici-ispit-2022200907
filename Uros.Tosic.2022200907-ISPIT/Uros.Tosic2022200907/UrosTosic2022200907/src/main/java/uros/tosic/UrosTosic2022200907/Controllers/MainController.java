package uros.tosic.UrosTosic2022200907.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import uros.tosic.UrosTosic2022200907.DTOs.BibliotekaDTO;
import uros.tosic.UrosTosic2022200907.DTOs.KnjigaDTO;
import uros.tosic.UrosTosic2022200907.Entities.BibliotekaEntity;
import uros.tosic.UrosTosic2022200907.Entities.KnjigaEntity;
import uros.tosic.UrosTosic2022200907.Repos.BibliotekaRepo;
import uros.tosic.UrosTosic2022200907.Repos.KnjigaRepo;

//ovde stoji logika
//komunikator izmedju korisnika i servera
@RestController
@CrossOrigin(origins = "*")
public class MainController {
    @Autowired
    private BibliotekaRepo bibliotekaRepo;

    @Autowired
    private KnjigaRepo knjigaRepo;

    @GetMapping("/dohvatiBiblioteke")
    public ResponseEntity<List<BibliotekaEntity>> dohvatiBiblioteke() {
        return ResponseEntity.ok(bibliotekaRepo.findAll());
    }
    //registrovanje biblioteke
    @PostMapping("/registrujBiblioteku")
    public ResponseEntity<BibliotekaEntity> registrujBiblioteku(@RequestBody BibliotekaDTO request) {
        BibliotekaEntity novaBiblioteka = bibliotekaRepo.save(new BibliotekaEntity(request.ime, request.adresa));
        return ResponseEntity.ok(novaBiblioteka);
    }

    @GetMapping("/dohvatiKnjige/{bibliotekaId}")
    public ResponseEntity<List<KnjigaEntity>> dohvatiKnjige(@PathVariable Long bibliotekaId ) {
        return ResponseEntity.ok(knjigaRepo.findByBibliotekaId(bibliotekaId));
    }

    @PostMapping("/dodajKnjigu")
    public ResponseEntity<KnjigaEntity> dodajKnjigu(@RequestBody KnjigaDTO request) throws Exception {
        BibliotekaEntity biblioteka = bibliotekaRepo
            .findById(request.bibliotekaId)
            .orElseThrow(() -> new Exception("Ne postoji biblioteka id: " + request.bibliotekaId));
        KnjigaEntity novaKnjiga = knjigaRepo.save(new KnjigaEntity(request.ime, request.cena, biblioteka.getId()));
        return ResponseEntity.ok(novaKnjiga);
    }
}
