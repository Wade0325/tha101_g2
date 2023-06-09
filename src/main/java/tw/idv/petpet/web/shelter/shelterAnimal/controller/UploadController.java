package tw.idv.petpet.web.shelter.shelterAnimal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;
import tw.idv.petpet.web.shelter.shelterAnimal.service.ShelterAnimalService;
import tw.idv.petpet.web.shelter.shelterMember.entity.ShelterMember;

@RestController
@RequestMapping("shelter/upload")
public class UploadController {
	@Autowired
	private ShelterAnimalService service;
	
	@PostMapping
	public ShelterAnimal upload(@RequestBody ShelterAnimal shelteranimal, HttpSession session) {
		ShelterMember member = (ShelterMember)session.getAttribute("shelterEmail");
		shelteranimal.setShelterId(member.getShelterId());
		shelteranimal.setShelterName(member.getShelterName());
		if (shelteranimal == null) {
		shelteranimal = new ShelterAnimal();
		return shelteranimal;
	}
		System.out.println("Upload controller收到");
		return service.upload(shelteranimal);
	}
	
}