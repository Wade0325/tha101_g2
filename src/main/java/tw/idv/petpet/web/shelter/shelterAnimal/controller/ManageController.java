package tw.idv.petpet.web.shelter.shelterAnimal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;
import tw.idv.petpet.web.shelter.shelterAnimal.service.ShelterAnimalService;

@RestController
@RequestMapping("shelter")
public class ManageController {
	@Autowired
	private ShelterAnimalService service;
	
	@PostMapping("manage")
	@ResponseBody
		public List<ShelterAnimal> manage() {
			List<ShelterAnimal> animal = service.findAll();
			return animal;
		}
	
	@DeleteMapping("deleteanimal/{animalId}")
	@ResponseBody
	public ResponseEntity<Object> delete(@PathVariable Integer animalId) {
	    boolean successful = service.remove(animalId);
	    System.out.println("aaa");
	    
	    if (successful) {
	        return ResponseEntity.ok().build(); // 返回成功响应
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 返回失败响应
	    }
	}
}
