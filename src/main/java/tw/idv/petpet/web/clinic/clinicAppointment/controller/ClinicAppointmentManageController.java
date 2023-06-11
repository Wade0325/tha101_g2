package tw.idv.petpet.web.clinic.clinicAppointment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.clinic.clinicAppointment.entity.ClinicAppointment;
import tw.idv.petpet.web.clinic.clinicAppointment.service.ClinicAppointmentService;
import tw.idv.petpet.web.clinic.vet.entity.Vet;
import tw.idv.petpet.web.user.entity.User;

@RestController
public class ClinicAppointmentManageController {

	@Autowired
	private ClinicAppointmentService service;

	@GetMapping("/Appointment/all")
	@ResponseBody
	public Map<String, List<ClinicAppointment>> init() {
		List<ClinicAppointment> clinicAppointmentlList = service.listAll();
		
		 Map<String, List<ClinicAppointment>> map = new HashMap<>();
		  map.put("data", clinicAppointmentlList);
		  return map;

	}

}
