package tw.idv.petpet.web.clinic.clinicAppointment.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
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

	@PostMapping("/clinicAppointmentInsert")
	public ClinicAppointment insert(@RequestBody ClinicAppointment clinicAppointment) {
		service.save(clinicAppointment);
		return clinicAppointment;
	}

	@PutMapping("/clinicAppointment/{reservationNumber}")
	public String update(@PathVariable Integer reservationNumber, @RequestBody ClinicAppointment clinicAppointment) {
		service.update(reservationNumber, clinicAppointment);
		return "執行update操作";
	}

	@DeleteMapping("/clinicAppointment/{reservationNumber}")
	public void deleteById(@PathVariable Integer reservationNumber) {
		service.deleteById(reservationNumber);
	}

	@PostMapping("/clinicAppointment/findByReservationNumber/{reservationNumber}")
	public ClinicAppointment findByReservationNumber(@PathVariable Integer reservationNumber) {
		ClinicAppointment clinicAppointment = service.findByReservationNumber(reservationNumber).orElse(null);
		return clinicAppointment;
	}

	@PostMapping("/clinicAppointment/all")
	public List<ClinicAppointment> findAll() {
		List<ClinicAppointment> clinicAppointmentlList = service.listAll();
		return clinicAppointmentlList;
	}

	@PostMapping("/clinicAppointment/{ClinicName}")
	public List<ClinicAppointment> findByClinicName(@PathVariable String ClinicName) {
		List<ClinicAppointment> clinicAppointment = service.findByClinicName(ClinicName);
		return clinicAppointment;
	}

	@GetMapping("/clinicAppointment")
	public List<ClinicAppointment> findByOwnerName(ClinicAppointment clinicAppointment, HttpSession session) {
		User user = (User) session.getAttribute("userAccount");
		clinicAppointment.setOwnerName(user.getUsername());
		List<ClinicAppointment> list = service.findByOwnerName(clinicAppointment.getOwnerName());
		return list;
	}
}
