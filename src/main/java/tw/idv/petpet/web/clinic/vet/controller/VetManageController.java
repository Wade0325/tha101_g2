package tw.idv.petpet.web.clinic.vet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.clinic.vet.entity.Vet;
import tw.idv.petpet.web.clinic.vet.repository.VetRepository;
import tw.idv.petpet.web.clinic.vet.service.VetService;
import tw.idv.petpet.web.clinicMember.entity.PriceList;

@RestController
@RequestMapping("vet")
public class VetManageController {

	@Autowired
	private VetService service;
	@Autowired
	private VetRepository vetRepository;

	@PutMapping("update/{vetSn}")
	public String update(@PathVariable Integer vetSn, @RequestBody Vet vet) {
		service.update(vetSn, vet);
		return "執行update操作";
	}

	@DeleteMapping("delete/{vetSn}")
	public String delete(@PathVariable Integer vetSn) {
		service.deleteById(vetSn);
		return "執行delete操作";
	}

	@GetMapping("find/{vetSn}")
	public Vet findById(@PathVariable Integer vetSn) {
		Vet vet = service.findById(vetSn).orElse(null);
		return vet;
	}

	
	@GetMapping("/init")
	@ResponseBody
	public Map<String, List<Vet>> init() {
	  List<Vet> vets = vetRepository.findAll();

	  Map<String, List<Vet>> map = new HashMap<>();
	  map.put("data", vets);
	  return map;
	}
	
	
	
}
