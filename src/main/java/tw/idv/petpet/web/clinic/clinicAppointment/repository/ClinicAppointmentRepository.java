package tw.idv.petpet.web.clinic.clinicAppointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.petpet.web.clinic.clinicAppointment.entity.ClinicAppointment;
import tw.idv.petpet.web.clinicMember.entity.ClinicMember;

public interface ClinicAppointmentRepository extends JpaRepository<ClinicAppointment, Integer> {
	
	//自己寫的方法
	List<ClinicAppointment> findByClinicName(String clinicName);

}
