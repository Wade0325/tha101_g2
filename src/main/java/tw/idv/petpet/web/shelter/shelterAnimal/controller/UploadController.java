package tw.idv.petpet.web.shelter.shelterAnimal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;
import tw.idv.petpet.web.shelter.shelterAnimal.service.ShelterAnimalService;

@RestController
@RequestMapping("shelter/upload")
public class UploadController {
	@Autowired
	private ShelterAnimalService service;
	
	@PostMapping
	public ShelterAnimal upload(@RequestBody ShelterAnimal shelteranimal) {
		if (shelteranimal == null) {
		shelteranimal = new ShelterAnimal();
		return shelteranimal;
	}
		System.out.println("Upload controller收到");
		return service.upload(shelteranimal);
	}
	
}
