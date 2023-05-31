package tw.idv.petpet.web.clinicMember.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.clinicMember.Repository.PriceListRespository;
import tw.idv.petpet.web.clinicMember.entity.ClinicMember;
import tw.idv.petpet.web.clinicMember.entity.PriceList;

@RestController
@RequestMapping("PriceList")
public class PriceListController {
	
	@Autowired
	private PriceListRespository priceListRespository;
	private List<PriceList> PriceList;
	
//	@PostMapping
//	public String insert(@RequestBody PriceList priceList) {
//		priceListRespository.save(priceList);
//		 return "執行資料庫creat操作";
//	}


	@PutMapping("/{clinicServiceId}")
	public String update(@PathVariable Integer clinicServiceId,
						@RequestBody PriceList priceList) { 
		PriceList p  = priceListRespository.findById(clinicServiceId).orElse(null);
		
		if (p!= null) {
			p.setClinicServiceName(priceList.getClinicServiceName());
			p.setServicePrice(priceList.getServicePrice());
			p.setServiceDiscountPrice(priceList.getServiceDiscountPrice());
			p.setServiceItem1(priceList.getServiceItem1());
			p.setServiceItem2(priceList.getServiceItem2());
			p.setServiceItem3(priceList.getServiceItem3());
			p.setServiceItem4(priceList.getServiceItem4());
			p.setServiceImg(priceList.getServiceImg());
			priceListRespository.save(p);
			return "執行資料庫update操作";
		}	else {
			return "update失敗，數據不存在";
		}
	}
	
	@DeleteMapping("/PriceList/{clinicServiceId}")
	public String delete(@PathVariable Integer clinicServiceId) {
		priceListRespository.deleteById(clinicServiceId);
		
		 return "執行資料庫delect操作";
	}
	
	@GetMapping("/PriceList/{clinicServiceId}")
	public PriceList read(@PathVariable Integer clinicServiceId) {
		PriceList priceList = priceListRespository.findById(clinicServiceId).orElse(null);
		 return priceList;
	}
	
//	//findAll
//	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public List<PriceList> manage() {
//		List<PriceList> priceList = priceListRespository.findAll();
//		return priceList;
//	}

}
