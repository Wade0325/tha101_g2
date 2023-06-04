package tw.idv.petpet.web.shelter.shelterAnimal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;
import tw.idv.petpet.web.shelter.shelterAnimal.service.ShelterAnimalService;

@RestController
@RequestMapping("shelter")
public class AnimalEditController {
	@Autowired
	private ShelterAnimalService service;
	@PostMapping("animalfindbyid/{animalId}")
	@ResponseBody
	public ShelterAnimal read(@PathVariable Integer animalId) {
		ShelterAnimal shelterAnimal = service.findById(animalId).orElse(null);

		service.findById(animalId);
		System.out.println("動物詳細findById完成");
		return shelterAnimal;
	}
	@PostMapping("adoptfindbyid/{animalId}")
	@ResponseBody
	public ShelterAnimal adopt(@PathVariable Integer animalId) {
		ShelterAnimal shelterAnimal = service.findById(animalId).orElse(null);
		
		service.findById(animalId);
		System.out.println("領養表單findById完成");
		return shelterAnimal;
	}
	
	@PutMapping("animaledit/{animalId}")
	@ResponseBody
	public ShelterAnimal update(@PathVariable Integer animalId,@RequestBody ShelterAnimal shelterAnimal) {
		shelterAnimal.setAnimalId(animalId);
		service.update(shelterAnimal);
		return shelterAnimal;
	}
}
