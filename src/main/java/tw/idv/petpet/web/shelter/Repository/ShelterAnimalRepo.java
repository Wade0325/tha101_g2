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
	
	@Query(value = "SELECT * FROM Shelter_Animal WHERE " +
	        "(animal_area = :animalArea OR :animalArea IS NULL) AND " +
	        "(animal_gender = :animalGender OR :animalGender IS NULL) AND " +
	        "(animal_type = :animalType OR :animalType IS NULL) AND " +
	        "(if_adopted = :ifAdopted OR :ifAdopted IS NULL)", nativeQuery = true)
	List<ShelterAnimal> findByAnimalType(String animalArea,String animalGender,String animalType, Integer ifAdopted);

	@Query(value = "select * from shelter_animal where shelter_id = ?1",nativeQuery = true)
	List<ShelterAnimal> findByShelterId(Integer shelterId);
}
