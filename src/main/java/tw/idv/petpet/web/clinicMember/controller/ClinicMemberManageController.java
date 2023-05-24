package tw.idv.petpet.web.clinicMember.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@GetMapping
	public String manage(Model model) {
		List<ClinicMember> clinicMemberList = service.findAll();
		model.addAttribute("clinicMemberList", clinicMemberList);
		return "templates/manage";
	}
}
