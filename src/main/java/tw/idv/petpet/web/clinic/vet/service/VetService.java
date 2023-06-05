package tw.idv.petpet.web.clinic.vet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.petpet.web.clinic.vet.entity.Vet;
import tw.idv.petpet.web.clinic.vet.repository.VetRepository;

@Service
@Transactional
public class VetService {

	@Autowired
	private VetRepository vetRepository;

	public void save(Vet vet) {
		vetRepository.save(vet);
	}

	public void update(Integer vetSn, Vet vet) {
		Vet vet1 = vetRepository.findById(vetSn).orElse(null);
		// vetSn不能修改
		if (vet1 != null) {
			vet1.setClinicId(vet.getClinicId());
			vet1.setVetName(vet.getVetName());
			vet1.setVetGender(vet.getVetGender());
			vet1.setSpecialty(vet.getSpecialty());
			vet1.setSeniority(vet.getSeniority());
			vetRepository.save(vet1);
		}
	}

	public Optional<Vet> findById(Integer vetSn) {
		return vetRepository.findById(vetSn);
	}

	public void deleteById(Integer vetSn) {
		vetRepository.deleteById(vetSn);
	}

	public List<Vet> listAll() {
		return vetRepository.findAll();
	}
}
