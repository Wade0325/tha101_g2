package tw.idv.petpet.web.shelter.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.idv.petpet.web.shelter.adoptApply.entity.AdoptApply;

public interface AdoptApplyRepo extends JpaRepository<AdoptApply, Integer> {

	List<AdoptApply> findByanimalId(Integer animalId);
	
}
