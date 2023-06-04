package tw.idv.petpet.web.shelter.adoptApply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shelter.adoptApply.entity.AdoptApply;
import tw.idv.petpet.web.shelter.adoptApply.service.AdoptApplyService;
import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;
import tw.idv.petpet.web.shelter.shelterAnimal.service.ShelterAnimalService;

@RestController
@RequestMapping("shelter/adoptupload")
public class AdoptUploadController {
		@Autowired
		private AdoptApplyService service;
		
		@PostMapping
		public AdoptApply upload(@RequestBody AdoptApply AdoptApply) {
			if (AdoptApply == null) {
				AdoptApply = new AdoptApply();
			return AdoptApply;
		}
			System.out.println("Upload controller收到");
			return service.upload(AdoptApply);
		}
}
