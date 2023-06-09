package tw.idv.petpet.web.shelter.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.idv.petpet.web.shelter.adoptApply.entity.AdoptApply;
import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;
import tw.idv.petpet.web.shelter.shelterMember.entity.ShelterMember;

public interface ShelterAnimalRepo extends JpaRepository<ShelterAnimal, Integer>{
	
	List<ShelterAnimal> findByifAdopted(Integer ifAdopted);
	
	@Query(value = "SELECT * FROM Shelter_Animal where animal_type = ?1 and if_adopted = 0", nativeQuery = true)
	ShelterAnimal findByAnimalType(String aniamlType);

}
