package tw.idv.petpet.web.clinicMember.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.petpet.web.clinicMember.entity.ClinicMember;

public interface ClinicMemberRepository extends JpaRepository<ClinicMember	, Integer>{

	ClinicMember findByAccountAndPassword(String clinicEmail, String clinicPassword);

}
