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

	public void update(Integer reservationNumber, ClinicAppointment clinicAppointment) {
		ClinicAppointment clinicAppointment1 = clinicAppointmentRepository.findById(reservationNumber).orElse(null);
		// clinicId不可修改
		if (clinicAppointment1 != null) {
			clinicAppointment1.setClinicName(clinicAppointment.getClinicName());
			clinicAppointment1.setVetName(clinicAppointment.getVetName());
			clinicAppointment1.setAppointDate(clinicAppointment.getAppointDate());
			clinicAppointment1.setAppointTime(clinicAppointment.getAppointTime());
			clinicAppointment1.setOwnerMobile(clinicAppointment.getOwnerMobile());
			clinicAppointment1.setPetType(clinicAppointment.getPetType());
			clinicAppointment1.setPetName(clinicAppointment.getPetName());
			clinicAppointment1.setServiceItem(clinicAppointment.getServiceItem());
			clinicAppointment1.setOwnerName(clinicAppointment.getOwnerName());
			clinicAppointment1.setPetSituation(clinicAppointment.getPetSituation());
			clinicAppointmentRepository.save(clinicAppointment1);
		}
	}

	public Optional<ClinicAppointment> findByReservationNumber(Integer reservationNumber) {
		return clinicAppointmentRepository.findById(reservationNumber);
	}

	public void deleteById(Integer reservationNumber) {
		clinicAppointmentRepository.deleteById(reservationNumber);
	}

	public List<ClinicAppointment> listAll() {
		return clinicAppointmentRepository.findAll();
	}
	
	public List<ClinicAppointment> findByClinicName(String clinicName) {
		return clinicAppointmentRepository.findByClinicName(clinicName);
	}
}
