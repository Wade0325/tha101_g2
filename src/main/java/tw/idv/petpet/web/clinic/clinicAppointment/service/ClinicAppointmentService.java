package tw.idv.petpet.web.clinic.clinicAppointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.petpet.web.clinic.clinicAppointment.entity.ClinicAppointment;
import tw.idv.petpet.web.clinic.clinicAppointment.repository.ClinicAppointmentRepository;

@Service
@Transactional
public class ClinicAppointmentService {

	@Autowired
	private ClinicAppointmentRepository clinicAppointmentRepository;

	public void save(ClinicAppointment clinicAppointment) {
		clinicAppointmentRepository.save(clinicAppointment);
	}

	public Optional<ClinicAppointment> findById(Integer reservationNumber) {
		return clinicAppointmentRepository.findById(reservationNumber);
	}

	public void deleteById(Integer reservationNumber) {
		clinicAppointmentRepository.deleteById(reservationNumber);
	}

	public List<ClinicAppointment> listAll() {
		return clinicAppointmentRepository.findAll();
	}
}
