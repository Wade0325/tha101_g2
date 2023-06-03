package tw.idv.petpet.web.clinicMember.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tw.idv.petpet.web.clinicMember.Repository.PriceListRespository;
import tw.idv.petpet.web.clinicMember.entity.PriceList;

@RestController
@RequestMapping("PriceList")
public class PriceListController {
	
	@Autowired
	private PriceListRespository priceListRespository;

	@PutMapping("update/{clinicServiceId}")
	public String update(@PathVariable Integer clinicServiceId,
						
						@RequestBody PriceList priceList) throws IOException { 
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
	
	@DeleteMapping("/delete/{clinicServiceId}")
	public String delete(@PathVariable Integer clinicServiceId) {
		priceListRespository.deleteById(clinicServiceId);
		
		 return "執行資料庫delect操作";
	}
	
	@GetMapping("/{clinicServiceId}")
	public PriceList read(@PathVariable Integer clinicServiceId) {
		PriceList priceList = priceListRespository.findById(clinicServiceId).orElse(null);
		 return priceList;
	}
	
	 @GetMapping("/init")
	 public Map<String, List<PriceList>> init() {
	  // 调用 findAll() 获取数据
	    List<PriceList> priceLists = priceListRespository.findAll();

	//  // 创建一个包含 "data" 属性的 JsonObject
	//  JsonObject jsonObject = new JsonObject();
	//  JsonArray jsonArray = new Gson().toJsonTree(priceLists).getAsJsonArray();
	//  jsonObject.add("data", jsonArray);
	//
	//  // 将 JsonObject 转换为 JSON 字符串
	//  String json = jsonObject.toString();
	  Map<String, List<PriceList>> map = new HashMap();
	  map.put("data", priceLists);
	  return map;

	 }

}
