package tw.idv.petpet.web.shelter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;

public interface ShelterAnimalRepo extends JpaRepository<ShelterAnimal, Integer>{


}
