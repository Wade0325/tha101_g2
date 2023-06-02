package tw.idv.petpet.web.clinic.petCases.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.petpet.web.clinic.petCases.entity.PetCases;

public interface PetCasesRepository extends JpaRepository<PetCases, Integer>{

}
