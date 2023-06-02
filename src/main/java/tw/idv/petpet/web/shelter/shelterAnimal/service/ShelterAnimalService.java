package tw.idv.petpet.web.shelter.shelterAnimal.service;

import java.util.List;

import tw.idv.petpet.core.service.CoreService;
import tw.idv.petpet.web.member.entity.Member;
import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;
import tw.idv.petpet.web.shelter.shelterMember.entity.ShelterMember;


public interface ShelterAnimalService extends CoreService {
	ShelterAnimal upload(ShelterAnimal ShelterAnimal);
	
	List<ShelterAnimal> findAll();
	
	boolean remove(Integer animalId);

	ShelterAnimal findById(Integer animalId);
	
	ShelterAnimal update(ShelterAnimal ShelterAnimal);
	
	

	
}
