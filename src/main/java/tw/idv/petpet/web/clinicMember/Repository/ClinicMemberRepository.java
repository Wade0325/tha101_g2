package tw.idv.petpet.web.clinicMember.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.idv.petpet.web.clinicMember.entity.ClinicMember;

public interface ClinicMemberRepository extends JpaRepository<ClinicMember	, Integer>{

	@Query(value = "SELECT * FROM clinic_member where clinic_email = ?1", nativeQuery = true)
	ClinicMember findByClinicEmail(String clinicEmail);

	@Query(value = "SELECT * FROM clinic_member where clinic_email = ?1 and clinic_password = ?2", nativeQuery = true)
	ClinicMember findByClinicEmailAndPassword(String clinicEmail, String clinicPassword);

}
