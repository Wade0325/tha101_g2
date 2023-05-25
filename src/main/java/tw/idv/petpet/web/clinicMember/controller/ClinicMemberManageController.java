package tw.idv.petpet.web.clinicMember.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.idv.petpet.web.clinicMember.entity.ClinicMember;
import tw.idv.petpet.web.clinicMember.service.ClinicMemberService;

@Controller
@RequestMapping("clinicMember/manage")
public class ClinicMemberManageController {

	@Autowired
	private ClinicMemberService service;

//	@GetMapping
//	public String manage(Model model) {
//		List<ClinicMember> clinicMemberList = service.findAll();
//		model.addAttribute("clinicMemberList", clinicMemberList);
//		return "../WEB-INF/clinicMember/manage.jsp";
//	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ClinicMember> manage() {
	    List<ClinicMember> clinicMemberList = service.findAll();
	    return clinicMemberList;
	}
}
