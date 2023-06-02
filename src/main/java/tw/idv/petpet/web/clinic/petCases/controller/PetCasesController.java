package tw.idv.petpet.web.clinic.petCases.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.clinic.petCases.entity.PetCases;
import tw.idv.petpet.web.clinic.petCases.service.PetCasesService;

@RestController
public class PetCasesController {

	@Autowired
	private PetCasesService service;

	@PostMapping("/petCases")
	public String insert(@RequestBody PetCases petCases) {
		service.save(petCases);
		return "執行create操作";
	}

	@PutMapping("/petCases/{casesSn}")
	public String update(@PathVariable Integer casesSn, @RequestBody PetCases petCases) {
		PetCases petCases1 = service.findById(casesSn).orElse(null);
		// casesSn不能修改
		if (petCases1 != null) {
			petCases1.setVetSn(petCases.getVetSn());
			petCases1.setUserId(petCases.getUserId());
			petCases1.setAppointDate(petCases.getAppointDate());
			petCases1.setOwnerMobile(petCases.getOwnerMobile());
			petCases1.setPetType(petCases.getPetType());
			petCases1.setPetName(petCases.getPetName());
			petCases1.setPetGender(petCases.getPetGender());
			petCases1.setPetAge(petCases.getPetAge());
			petCases1.setPetSituation(petCases.getPetSituation());
			petCases1.setTreatment(petCases.getTreatment());
			petCases1.setResult(petCases.getResult());
			service.save(petCases1);
			return "執行update操作";
		} else {
			return "資料不存在，操作失敗";
		}
	}
	
	@DeleteMapping("/petCases/{casesSn}")
	public String deleteId(@PathVariable Integer casesSn) {
		service.deleteById(casesSn);
		return "執行delete操作";
	}
	
	
	@GetMapping("/petCases/{casesSn}")
	public PetCases findById(@PathVariable Integer casesSn) {
		PetCases petCases = service.findById(casesSn).orElse(null);
		return petCases;
	}
	
	@PostMapping("/petCases/all")
	public List<PetCases> findAll(){
		List<PetCases> list = service.listAll();
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
