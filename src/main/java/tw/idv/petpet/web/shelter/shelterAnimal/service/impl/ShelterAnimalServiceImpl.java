package tw.idv.petpet.web.shelter.shelterAnimal.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.petpet.web.shelter.Repository.ShelterAnimalRepo;
import tw.idv.petpet.web.shelter.shelterAnimal.dao.ShelterAnimalDao;
import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;
import tw.idv.petpet.web.shelter.shelterAnimal.service.ShelterAnimalService;

@Service
public class ShelterAnimalServiceImpl implements ShelterAnimalService{
	@Autowired
	private ShelterAnimalDao dao;
	@Autowired
	private ShelterAnimalRepo repo;

	@Transactional
	@Override
	public ShelterAnimal upload(ShelterAnimal shelteranimal) {
		final int resultCount = dao.insert(shelteranimal);
		System.out.println("upload service收到");
		if (shelteranimal.getAnimalName() == null) {
			shelteranimal.setMessage("收容編號未輸入");
			shelteranimal.setSuccessful(false);
			return shelteranimal;
		}
		if (shelteranimal.getAnimalName() == null) {
			shelteranimal.setMessage("動物名稱未輸入");
			shelteranimal.setSuccessful(false);
			return shelteranimal;
		}
		if (shelteranimal.getAnimalCategory() == null) {
			shelteranimal.setMessage("動物品種未輸入");
			shelteranimal.setSuccessful(false);
			return shelteranimal;
		}
		if (shelteranimal.getAnimalType() == null) {
			shelteranimal.setMessage("動物種類未輸入");
			shelteranimal.setSuccessful(false);
			return shelteranimal;
		}
		if (shelteranimal.getAnimalColor() == null) {
			shelteranimal.setMessage("毛色未輸入");
			shelteranimal.setSuccessful(false);
			return shelteranimal;
		}
		if (shelteranimal.getAnimalGender() == null) {
			shelteranimal.setMessage("性別未輸入");
			shelteranimal.setSuccessful(false);
			return shelteranimal;
		}
		if (shelteranimal.getAnimalDescribe() == null) {
			shelteranimal.setMessage("描述未輸入");
			shelteranimal.setSuccessful(false);
			return shelteranimal;
		}
		if (shelteranimal.getAnimalAge() == null) {
			shelteranimal.setMessage("年齡未輸入");
			shelteranimal.setSuccessful(false);
			return shelteranimal;
		}

		
		shelteranimal.setMessage("上傳成功");
		shelteranimal.setSuccessful(true);	
		return shelteranimal;
	}

	@Override
	public List<ShelterAnimal> findAll() {
	    return repo.findAll();
	}

	
	@Transactional
	@Override
	public boolean remove(Integer animalId) {
		repo.deleteById(animalId);		return true;
	}
	
	@Override
	public ShelterAnimal findById(Integer animalId) {
        Optional<ShelterAnimal> result = repo.findById(animalId);
        if (result.isPresent()) {
        	ShelterAnimal entity = result.get();
        } else {
        }
		return null;
    }
	
	@Override
	public ShelterAnimal update(ShelterAnimal ShelterAnimal) {
		repo.save(ShelterAnimal);
		return ShelterAnimal;
	}

}
