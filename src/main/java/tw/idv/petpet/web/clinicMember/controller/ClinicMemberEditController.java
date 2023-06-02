package tw.idv.petpet.web.clinicMember.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.idv.petpet.web.clinicMember.service.ClinicMemberService;

@RestController
@RequestMapping("clinicMember/edit")
@SessionAttributes({ "clinicmember" })
public class ClinicMemberEditController {

	@Autowired
	private ClinicMemberService service;
	
	
}
