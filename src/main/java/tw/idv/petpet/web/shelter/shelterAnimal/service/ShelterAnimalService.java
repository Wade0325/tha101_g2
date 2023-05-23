package tw.idv.petpet.web.shelter.shelterAnimal.service;

import tw.idv.petpet.core.service.CoreService;
import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;


public interface ShelterAnimalService extends CoreService {
	boolean remove(Integer animalId);

	boolean save(ShelterAnimal ShelterAnimal);
	
}
