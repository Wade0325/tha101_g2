package tw.idv.petpet.web.shelter.shelterMember.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.core.pojo.Core;
import tw.idv.petpet.web.clinicMember.entity.ClinicMember;
import tw.idv.petpet.web.clinicMember.service.ClinicMemberService;
import tw.idv.petpet.web.shelter.Repository.ShelterMemberRepo;
import tw.idv.petpet.web.shelter.adoptApply.entity.AdoptApply;
import tw.idv.petpet.web.shelter.shelterMember.entity.ShelterMember;
import tw.idv.petpet.web.shelter.shelterMember.service.ShelterMemberService;
import tw.idv.petpet.web.user.entity.User;

	@RestController
	@RequestMapping("backstage")
	public class ShelterRegisterController {
		
		@Autowired
		private ShelterMemberService service;
		@Autowired
		private ShelterMemberRepo repo;
		
		@PostMapping("shelterregister")
		public Core upload(@RequestBody ShelterMember ShelterMember) {
			final Core core = new Core();
			if (ShelterMember == null) {
				core.setMessage("無此Id");
				core.setSuccessful(false); 
		}else {
			core.setSuccessful(repo.save(ShelterMember) != null);
			System.out.println("Upload controller收到");
		}
			return core;
		}

		@PostMapping("shelterlogin")
		public ShelterMember login(@RequestBody ShelterMember ShelterMember, HttpSession session) {
			System.out.println("Controller 開始執行 ShelterMemberlogin 方法");
			ShelterMember Session = service.login(ShelterMember);
			if (Session.isSuccessful()) {
				session.setAttribute("shelterEmail", Session);
			}
			System.out.println("Controller 執行 login 方法成功");
			return Session;
		}
		
}
