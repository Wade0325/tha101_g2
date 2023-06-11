package tw.idv.petpet.web.shelter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.idv.petpet.web.shelter.shelterMember.entity.ShelterMember;
import tw.idv.petpet.web.user.entity.User;

public interface ShelterMemberRepo extends JpaRepository<ShelterMember, Integer>{

	@Query(value = "SELECT * FROM Shelter_Member where shelter_email = ?1 and shelter_password = ?2", nativeQuery = true)
	ShelterMember findByAccountAndPassword(String shelterEmail, String shelterPassword);
}
