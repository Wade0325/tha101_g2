package tw.idv.petpet.web.clinic.clinicAppointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.clinic.clinicAppointment.entity.ClinicAppointment;
import tw.idv.petpet.web.clinic.clinicAppointment.service.ClinicAppointmentService;

@RestController
public class ClinicAppointmentController {

	@Autowired
	private ClinicAppointmentService service;

	@PostMapping("/clinicAppointment")
	public String insert(@RequestBody ClinicAppointment clinicAppointment) {
		service.save(clinicAppointment);
		return "執行create操作";
	}

	@PutMapping("/clinicAppointment/{reservationNumber}")
	public String update(@PathVariable Integer reservationNumber, @RequestBody ClinicAppointment clinicAppointment) {
		
		ClinicAppointment clinicAppointment1 = service.findById(reservationNumber).orElse(null);
		//cardId、clinicId、userId不可修改
		if (clinicAppointment1 != null) {
			clinicAppointment1.setVetName(clinicAppointment.getVetName());
			clinicAppointment1.setAppointDate(clinicAppointment.getAppointDate());
			clinicAppointment1.setAppointTime(clinicAppointment.getAppointTime());
			clinicAppointment1.setOwnerMobile(clinicAppointment.getOwnerMobile());
			clinicAppointment1.setPetType(clinicAppointment.getPetType());
			clinicAppointment1.setPetName(clinicAppointment.getPetName());
			clinicAppointment1.setServiceItem(clinicAppointment.getServiceItem());
			clinicAppointment1.setPetSituation(clinicAppointment.getPetSituation());
			service.save(clinicAppointment1);
			return "執行updqte操作";
		} else {
			return "資料不存在，操作失敗";
		}
	}
	
	@DeleteMapping("/clinicAppointment/{reservationNumber}")
	public String deleteById(@PathVariable Integer reservationNumber) {
		service.deleteById(reservationNumber);
		return "執行delete操作";
	}
	
	@GetMapping("/clinicAppointment/{reservationNumber}")
	public ClinicAppointment findById(@PathVariable Integer reservationNumber) {
		ClinicAppointment clinicAppointment = service.findById(reservationNumber).orElse(null);
		return clinicAppointment;
	}
	
	@PostMapping("/clinicAppointment/all")
	public List<ClinicAppointment> findAll() {
		List<ClinicAppointment> clinicAppointmentlList = service.listAll();
		return clinicAppointmentlList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
