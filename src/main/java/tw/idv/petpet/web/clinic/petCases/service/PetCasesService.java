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
