package uros.tosic.UrosTosic2022200907.Repos;
//ovde se ucitava klasa koju je vec neko napravio iz biblioteke za maven
import org.springframework.stereotype.Repository;
import uros.tosic.UrosTosic2022200907.Entities.KnjigaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


@Repository
public interface KnjigaRepo extends JpaRepository<KnjigaEntity, Long>{
    List<KnjigaEntity> findByBibliotekaId(Long biblioteka_id);
}
