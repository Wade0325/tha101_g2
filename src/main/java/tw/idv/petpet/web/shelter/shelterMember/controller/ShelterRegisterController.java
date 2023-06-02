package tw.idv.petpet.web.shelter.shelterMember.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.clinicMember.entity.ClinicMember;
import tw.idv.petpet.web.clinicMember.service.ClinicMemberService;
import tw.idv.petpet.web.shelter.shelterMember.entity.ShelterMember;
import tw.idv.petpet.web.shelter.shelterMember.service.ShelterMemberService;

	@RestController
	@RequestMapping("shelter")
	public class ShelterRegisterController {
		
		@Autowired
		private ShelterMemberService service;
		
		@PostMapping("register")
		public ShelterMember register(@RequestBody ShelterMember shelterMember) {
			if (shelterMember == null) {
				shelterMember = new ShelterMember();
				shelterMember.setMessage("無診所會員資訊");
				shelterMember.setSuccessful(false);
				return shelterMember;
			}
			System.out.println("Upload controller收到");
			return service.register(shelterMember);
		}
		
		@DeleteMapping("delete/{shelterId}")
		public void delete(@PathVariable Integer shelterId) {
			service.remove(shelterId);
			System.out.println("aaa");
		
		}
		
}
