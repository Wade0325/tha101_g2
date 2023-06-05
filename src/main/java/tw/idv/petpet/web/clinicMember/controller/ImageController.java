package tw.idv.petpet.web.clinicMember.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.clinicMember.Repository.PriceListRespository;
import tw.idv.petpet.web.clinicMember.entity.PriceList;

@RestController
public class ImageController {
	@Autowired
	PriceListRespository respository;
	
	@GetMapping("/img/{id}")
	public ResponseEntity<byte[]> getimg(@PathVariable Integer id) {
		Optional<PriceList>opt =  respository.findById(id);
		PriceList p =  opt.get();
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(p.getServiceImg());
	}
}
