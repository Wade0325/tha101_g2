package tw.idv.petpet.web.clinicMember.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tw.idv.petpet.web.clinicMember.entity.ClinicMember;

public interface ClinicMemberRepository extends JpaRepository<ClinicMember	, Integer>{

	@Query("SELECT cm FROM ClinicMember cm WHERE cm.clinicEmail = :email AND cm.clinicPassword = :password")
	ClinicMember findByEmailAndPassword(@Param("email") String clinicEmail, @Param("password") String clinicPassword);


}
