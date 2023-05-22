package tw.idv.petpet.web.clinicMember.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.clinicMember.entity.ClinicMember;
import tw.idv.petpet.web.clinicMember.service.ClinicMemberService;

@RestController
@RequestMapping("clinicMember/register")
public class ClinicMemberRegisterController {
	
	@Autowired
	private ClinicMemberService service;
	
	@PostMapping
	public ClinicMember register(@RequestBody ClinicMember clinicMember) {
		if (clinicMember == null) {
			clinicMember = new ClinicMember();
			clinicMember.setMessage("無診所會員資訊");
			clinicMember.setSuccessful(false);
			return clinicMember;
		}
		return service.register(clinicMember);
	}
}
