package tw.idv.petpet.web.shelter.shelterAnimal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PutMapping("animaledit/{animalId}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> update(@PathVariable Integer animalId, @RequestBody ShelterAnimal shelterAnimal) {
	    shelterAnimal.setAnimalId(animalId);

	    boolean successful = service.update(shelterAnimal) != null;  // 假設 service.update 方法返回一個布林值表示更新是否成功

	    Map<String, Object> responseBody = new HashMap<>();
	    responseBody.put("successful", successful);
	    return new ResponseEntity<>(responseBody, HttpStatus.OK);
	}
	@PutMapping("ifadopted/{animalId}")
	@ResponseBody
	public ShelterAnimal adopted(@PathVariable Integer animalId,@RequestBody ShelterAnimal shelterAnimal) {
		shelterAnimal.setAnimalId(animalId);
		service.adopted(shelterAnimal);
		return shelterAnimal;
	}
}
