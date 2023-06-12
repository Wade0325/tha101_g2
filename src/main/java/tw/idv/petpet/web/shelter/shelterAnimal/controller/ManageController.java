package tw.idv.petpet.web.shelter.shelterAnimal.controller;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;
import tw.idv.petpet.web.shelter.shelterAnimal.service.ShelterAnimalService;
import tw.idv.petpet.web.shelter.shelterMember.entity.ShelterMember;

@RestController
@RequestMapping("shelter")
public class ManageController {
	@Autowired
	private ShelterAnimalService service;
	
	@PostMapping("animalmanage")
	@ResponseBody
		public List<ShelterAnimal> animalmanage(HttpSession session) {
		ShelterMember member = (ShelterMember) session.getAttribute("shelterEmail");
		  List<ShelterAnimal> animals = service.findByShelterId(member.getShelterId());
		    return animals;
		}
	
	@PostMapping("manage")
	@ResponseBody
		public List<ShelterAnimal> manage(@PathVariable Integer shelterId) {
		  List<ShelterAnimal> animals = service.findAll();		    
		    return animals;
		}
	@PostMapping("findbyifadopted/{ifAdopted}")
	@ResponseBody
	public List<ShelterAnimal> ifadopted(@PathVariable Integer ifAdopted){
		List<ShelterAnimal> animals = service.findByifAdopted(ifAdopted);;
		return animals;
	}
	@PostMapping("search")
	@ResponseBody
	public List<ShelterAnimal> search(@RequestBody ShelterAnimal shelterAnimal) {
		System.out.println("Controller 開始執行search 方法");
		return service.findByAnimalType(shelterAnimal);
		
		
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
