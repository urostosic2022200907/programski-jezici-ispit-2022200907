package uros.tosic.UrosTosic2022200907.Repos;
//ovde se ucitava klasa koju je vec neko napravio iz biblioteke za maven
import org.springframework.stereotype.Repository;
import uros.tosic.UrosTosic2022200907.Entities.BibliotekaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BibliotekaRepo extends JpaRepository<BibliotekaEntity, Long> {}
