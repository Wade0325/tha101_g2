package tw.idv.petpet.web.clinicMember.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.clinicMember.Repository.PriceListRespository;
import tw.idv.petpet.web.clinicMember.entity.PriceList;

@RestController
@RequestMapping("PriceList")
public class PriceListInsertController {
	
	@Autowired
	private PriceListRespository priceListRespository;
	
	@PostMapping
	public String insert(@RequestBody PriceList priceList) {
		priceListRespository.save(priceList);
		 return "執行資料庫creat操作";
	}
}
