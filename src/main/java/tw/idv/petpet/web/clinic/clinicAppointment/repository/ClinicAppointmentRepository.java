package tw.idv.petpet.web.clinic.clinicAppointment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.petpet.web.clinic.clinicAppointment.entity.ClinicAppointment;

public interface ClinicAppointmentRepository extends JpaRepository<ClinicAppointment, Integer> {
	
	//自己寫的方法
	Optional<ClinicAppointment> findByClinicName(String clinicName);
}
