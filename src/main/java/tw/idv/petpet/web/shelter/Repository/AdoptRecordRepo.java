package tw.idv.petpet.web.shelter.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.idv.petpet.web.shelter.adoptApply.entity.AdoptRecord;

public interface AdoptRecordRepo extends JpaRepository<AdoptRecord, Integer>{

	@Query(value = "select aa.adopter_name, aa.adopter_phone, sa.animal_name, sa.animal_type, aa.adopter_checked, aa.adopter_apply_date from adopt_apply aa join shelter_animal sa on aa.animal_id = sa.animal_id where user_account = ?1", nativeQuery = true)
	List<AdoptRecord> findRecord(String userAccount);
}
