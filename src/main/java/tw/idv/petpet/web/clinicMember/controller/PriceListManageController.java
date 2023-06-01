package tw.idv.petpet.web.clinicMember.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.petpet.web.clinicMember.Repository.PriceListRespository;
import tw.idv.petpet.web.clinicMember.entity.PriceList;

@RestController
@RequestMapping("PriceList/manage")
public class PriceListManageController {
	
	@Autowired
	private PriceListRespository priceListRespository;
	
	//findAll
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PriceList> manage() {
		List<PriceList> priceList = priceListRespository.findAll();
		return priceList;
	}
}
