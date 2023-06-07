package tw.idv.petpet.web.clinicMember.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.core.pojo.Core;
import tw.idv.petpet.web.clinicMember.entity.ClinicMember;
import tw.idv.petpet.web.clinicMember.service.ClinicMemberService;

@RestController
@RequestMapping("clinicMember/manage")
public class ClinicMemberManageController {

	@Autowired
	private ClinicMemberService service;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ClinicMember> manage() {
		List<ClinicMember> clinicMemberList = service.findAll();
		return clinicMemberList;
	}

	@DeleteMapping("{clinicId}")
	@ResponseBody
	public Core remove(@PathVariable Integer clinicId) {
		final Core core = new Core();
		if (clinicId == null) {
			core.setMessage("無此診所會員Id");
			core.setSuccessful(false);
		} else {
			core.setSuccessful(service.remove(clinicId));
		}
		return core;
	}

	@PutMapping
	@ResponseBody
	public Core save(@RequestBody ClinicMember clinicMember, HttpSession session) {
		final Core core = new Core();
		ClinicMember clinicMemberSession = (ClinicMember) session.getAttribute("clinicEmail");
		if (clinicMemberSession == null) {
			core.setMessage("無此會員");
			core.setSuccessful(false);
		} else {
			core.setSuccessful(service.save(clinicMember));
		}
		return core;
	}

}
