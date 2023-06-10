package tw.idv.petpet.web.shelter.adoptApply.service;

import java.util.List;
import java.util.Optional;

import tw.idv.petpet.core.service.CoreService;
import tw.idv.petpet.web.shelter.adoptApply.entity.AdoptApply;
import tw.idv.petpet.web.shelter.adoptApply.entity.AdoptRecord;

public interface AdoptApplyService extends CoreService{
	AdoptApply upload(AdoptApply AdoptApply);
	
	List<AdoptApply> findAll();
	
	List<AdoptApply> findByanimalId(Integer animalId);
	
	boolean remove(Integer applylId);

	Optional<AdoptApply> findById(Integer applyId);

	AdoptApply update(AdoptApply AdoptApply);
	
	List<AdoptRecord> findRecord(String userAccount);
	
}
