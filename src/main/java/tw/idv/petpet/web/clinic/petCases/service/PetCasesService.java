package tw.idv.petpet.web.clinic.petCases.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.petpet.web.clinic.petCases.entity.PetCases;
import tw.idv.petpet.web.clinic.petCases.repository.PetCasesRepository;

@Service
@Transactional
public class PetCasesService {

	@Autowired
	private PetCasesRepository petCasesRepository;

	public void save(PetCases petCases) {
		petCasesRepository.save(petCases);
	}

	public void update(Integer caseSn, PetCases petCases) {
		PetCases petCases1 = petCasesRepository.findById(caseSn).orElse(null);
		// casesSn不能修改
		if (petCases1 != null) {
			petCases1.setVetSn(petCases.getVetSn());
			petCases1.setUserId(petCases.getUserId());
			petCases1.setAppointDate(petCases.getAppointDate());
			petCases1.setOwnerMobile(petCases.getOwnerMobile());
			petCases1.setPetType(petCases.getPetType());
			petCases1.setPetName(petCases.getPetName());
			petCases1.setPetGender(petCases.getPetGender());
			petCases1.setPetAge(petCases.getPetAge());
			petCases1.setPetSituation(petCases.getPetSituation());
			petCases1.setTreatment(petCases.getTreatment());
			petCases1.setResult(petCases.getResult());
			petCasesRepository.save(petCases1);
		}
	}

	public Optional<PetCases> findById(Integer casesSn) {
		return petCasesRepository.findById(casesSn);
	}

	public void deleteById(Integer casesSn) {
		petCasesRepository.deleteById(casesSn);
	}

	public List<PetCases> listAll() {
		return petCasesRepository.findAll();
	}

}
