package tw.idv.petpet.web.clinic.petCases.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.petpet.web.clinic.petCases.entity.PetCase;
import tw.idv.petpet.web.clinic.petCases.repository.PetCaseRepository;

@Service
public class PetCaseService {

    @Autowired
    private PetCaseRepository petCaseRepository;

    public List<PetCase> getAllPetCases() {
        return petCaseRepository.findAll();
    }

    public Optional<PetCase> getPetCaseById(Integer id) {
        return petCaseRepository.findById(id);
    }

    public PetCase createPetCase(PetCase petCase) {
        return petCaseRepository.save(petCase);
    }

    public Optional<PetCase> updatePetCase(Integer id, PetCase petCase) {
        Optional<PetCase> existingPetCase = petCaseRepository.findById(id);
        if (existingPetCase.isPresent()) {
            petCase.setCasesSn(id);
            return Optional.of(petCaseRepository.save(petCase));
        } else {
            return Optional.empty();
        }
    }

    public void deletePetCase(Integer id) {
        petCaseRepository.deleteById(id);
    }

	public List<PetCase> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
