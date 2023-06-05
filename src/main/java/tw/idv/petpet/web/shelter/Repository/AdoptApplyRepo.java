package tw.idv.petpet.web.shelter.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.petpet.web.shelter.adoptApply.entity.AdoptApply;

public interface AdoptApplyRepo extends JpaRepository<AdoptApply, Integer>{
	 
	List<AdoptApply> findByanimalId(Integer animalId);
}
