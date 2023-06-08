package tw.idv.petpet.web.shelter.adoptApply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.core.pojo.Core;
import tw.idv.petpet.web.shelter.Repository.AdoptApplyRepo;
import tw.idv.petpet.web.shelter.adoptApply.entity.AdoptApply;
import tw.idv.petpet.web.shelter.adoptApply.service.AdoptApplyService;
import tw.idv.petpet.web.shelter.shelterAnimal.entity.ShelterAnimal;
import tw.idv.petpet.web.shelter.shelterAnimal.service.ShelterAnimalService;

@RestController
@RequestMapping("shelter/adoptupload")
public class AdoptUploadController {
		@Autowired
		private AdoptApplyService service;
		@Autowired
		private AdoptApplyRepo repo;
		
		@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		public Core upload(@RequestBody AdoptApply AdoptApply) {
			final Core core = new Core();
			if (AdoptApply == null) {
				core.setMessage("無此Id");
				core.setSuccessful(false); 
		}else {
			core.setSuccessful(repo.save(AdoptApply) != null);
			System.out.println("Upload controller收到");
		}
			return core;
		}
}
