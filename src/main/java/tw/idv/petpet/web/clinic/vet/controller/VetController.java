package tw.idv.petpet.web.clinic.vet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.clinic.vet.entity.Vet;
import tw.idv.petpet.web.clinic.vet.service.VetService;

@RestController
public class VetController {

	@Autowired
	private VetService service;

	@PostMapping("/vet")
	public String insert(@RequestBody Vet vet) {
		service.save(vet);
		return "執行create操作";
	}

	@PutMapping("/vet/{vetSn}")
	public String update(@PathVariable Integer vetSn, @RequestBody Vet vet) {
		service.update(vetSn, vet);
		return "執行update操作";
	}

	@DeleteMapping("/vet/{vetSn}")
	public String delete(@PathVariable Integer vetSn) {
		service.deleteById(vetSn);
		return "執行delete操作";
	}

	@GetMapping("/vet/{vetSn}")
	public Vet findById(@PathVariable Integer vetSn) {
		Vet vet = service.findById(vetSn).orElse(null);
		return vet;
	}

	@PostMapping("/vet/all")
	public List<Vet> findAll() {
		List<Vet> list = service.listAll();
		return list;
	}

}
