package tw.idv.petpet.web.ecpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.ecpay.service.EcpayService;

@RestController
public class EcpayController {

	@Autowired
	EcpayService service;

	@PostMapping("/ecpayCheck")
	public String ecpayCheck() {
		String form = service.ecpayCheck();

		return form;
	}
}
