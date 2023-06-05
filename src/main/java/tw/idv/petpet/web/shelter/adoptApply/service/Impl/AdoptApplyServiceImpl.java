package tw.idv.petpet.web.shelter.adoptApply.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.petpet.web.shelter.Repository.AdoptApplyRepo;
import tw.idv.petpet.web.shelter.adoptApply.entity.AdoptApply;
import tw.idv.petpet.web.shelter.adoptApply.service.AdoptApplyService;
import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;
@Service
public class AdoptApplyServiceImpl implements AdoptApplyService{
	@Autowired
	private AdoptApplyRepo repo;
	@Override
	public  AdoptApply upload(AdoptApply AdoptApply) {
		repo.save(AdoptApply);
		System.out.println("AdoptApply上傳 service收到");
		return  AdoptApply;
	}

	@Override
	public List<AdoptApply> findAll() {
		 return repo.findAll();
	}

	@Override
	public boolean remove(Integer applyId) {
		repo.deleteById(applyId);
		return true;
	}

	@Override
	public Optional<AdoptApply> findById(Integer applyId) {
		 return repo.findById(applyId);
	}

	@Override
	public  AdoptApply update(AdoptApply AdoptApply) {
		AdoptApply adopt = repo.findById(AdoptApply.getApplyId()).orElse(null);
		return repo.save(adopt);
	}

	@Override
	public List<AdoptApply> findByanimalId(Integer animalId) {
		return repo.findByanimalId(animalId);
	}

}
