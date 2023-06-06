package tw.idv.petpet.web.shelter.adoptApply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shelter.adoptApply.entity.AdoptApply;
import tw.idv.petpet.web.shelter.adoptApply.service.AdoptApplyService;
import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;

@RestController
@RequestMapping("shelter")
public class FindanimalIdController {
	@Autowired
	private AdoptApplyService service;
	@PostMapping("findbyanimalid/{animalId}")
	@ResponseBody
	public List<AdoptApply> getadopter(@PathVariable Integer animalId) {
		List<AdoptApply> adoptApply = service.findByanimalId(animalId);

		System.out.println("查看申請人findByanimalId完成");
		return adoptApply;
	}
	@PostMapping("adoptfindbyid/{applyId}")
	@ResponseBody
	public  AdoptApply adopt(@PathVariable Integer applyId) {
		 AdoptApply  adoptApply = service.findById(applyId).orElse(null);

		service.findById(applyId);
		System.out.println("申請表單findById完成");
		return  adoptApply;
	}
}
