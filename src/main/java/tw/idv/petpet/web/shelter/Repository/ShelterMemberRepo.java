package tw.idv.petpet.web.shelter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.petpet.web.shelter.shelterMember.entity.ShelterMember;

public interface ShelterMemberRepo extends JpaRepository<ShelterMember, Integer>{

}
