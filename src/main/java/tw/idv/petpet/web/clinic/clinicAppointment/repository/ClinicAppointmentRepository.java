package tw.idv.petpet.web.clinic.clinicAppointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.petpet.web.clinic.clinicAppointment.entity.ClinicAppointment;

public interface ClinicAppointmentRepository extends JpaRepository<ClinicAppointment, Integer>{

}
