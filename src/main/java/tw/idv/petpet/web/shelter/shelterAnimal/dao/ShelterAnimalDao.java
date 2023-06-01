package tw.idv.petpet.web.shelter.shelterAnimal.dao;

import tw.idv.petpet.core.dao.CoreDao;
import tw.idv.petpet.web.member.entity.Member;
import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;

public interface ShelterAnimalDao extends CoreDao<ShelterAnimal, Integer> {

	ShelterAnimal selectByanimalId(Integer animalId);

	ShelterAnimal selectByanimalNum(String animalNum);

	

}
