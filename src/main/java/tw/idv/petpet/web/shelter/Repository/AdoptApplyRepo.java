package tw.idv.petpet.web.shelter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.petpet.web.shelter.adoptApply.entity.AdoptApply;

public interface AdoptApplyRepo extends JpaRepository<AdoptApply, Integer>{

}
