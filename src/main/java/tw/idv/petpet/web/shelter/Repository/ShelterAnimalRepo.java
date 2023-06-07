package tw.idv.petpet.web.shelter.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.petpet.web.shelter.adoptApply.entity.AdoptApply;
import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;

public interface ShelterAnimalRepo extends JpaRepository<ShelterAnimal, Integer>{
	
	List<ShelterAnimal> findByifAdopted(Integer ifAdopted);

}
