package tw.idv.petpet.web.clinicMember.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.clinicMember.entity.ClinicMember;
import tw.idv.petpet.web.clinicMember.service.ClinicMemberService;

@RestController
@RequestMapping("clinicMember")
public class ClinicMemberRegisterController {
	
	@Autowired
	private ClinicMemberService service;
	
	@PostMapping("/register")
	public ClinicMember register(@RequestBody ClinicMember clinicMember, HttpSession session) {
		if (clinicMember == null) {
			clinicMember = new ClinicMember();
			clinicMember.setMessage("無診所會員資訊");
			clinicMember.setSuccessful(false);
			return clinicMember;
		}
		return service.register(clinicMember);
	}

	@PostMapping("/login")
	public ClinicMember login(@RequestBody ClinicMember clinicMember, HttpSession session) {
		System.out.println("執行login方法");
		ClinicMember clinicMemberSession = service.login(clinicMember);
		if (clinicMemberSession.isSuccessful()) {
			session.setAttribute("clinicEmail", clinicMemberSession);
		}
		System.out.println("login方法執行成功");
		return clinicMemberSession;
	}


	
	
	
	
	
	
	
	
	
	
	
}
