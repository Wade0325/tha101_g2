package tw.idv.petpet.web.clinic.ecpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.clinic.clinicAppointment.entity.ClinicAppointment;
import tw.idv.petpet.web.clinic.clinicAppointment.service.ClinicAppointmentService;
import tw.idv.petpet.web.clinic.ecpay.service.EcpayService;

@RestController
public class EcpayController {

	@Autowired
	EcpayService service;

	@Autowired
	ClinicAppointmentService clinicAppointmentService;

	@Autowired
	ClinicAppointment clinicAppointment;

	@PostMapping("/ecpayCheck")
	public String ecpayCheck() {

		String form = service.ecpayCheck();// 前往ecpay付款頁面

//		ClinicAppointment latestAppointment = clinicAppointmentService.getLatestReservation();
//		Integer reservation;
//		if (latestAppointment != null) {
//			reservation = latestAppointment.getReservationNumber();
//			clinicAppointmentService.updatePayInfo(reservation);
//		} else {
//			reservation = null;
//		}
		return form;
	}

	@PostMapping("/return")
	public String ReturnUrl() {
		ClinicAppointment latestAppointment = clinicAppointmentService.getLatestReservation();
		Integer reservation;
		if (latestAppointment != null) {
			reservation = latestAppointment.getReservationNumber();
			clinicAppointmentService.updatePayInfo(reservation);
		} else {
			reservation = null;
		}
		return "OK";
	}

}
