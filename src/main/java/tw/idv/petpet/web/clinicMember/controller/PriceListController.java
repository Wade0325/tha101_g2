package tw.idv.petpet.web.clinicMember.controller;

import java.io.IOException;
import java.util.Base64;
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
import org.springframework.web.bind.annotation.RestController;

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
//			byte imgview[] = Base64.getEncoder().encode(priceList.getServiceImg());
//			System.out.println(imgview);
//			byte[] serviceImgBytes = priceList.getServiceImg();
//			p.setServiceImg(imgview);
//			System.out.println("img" + priceList.getServiceImg());

			// 将字节数组编码为 Base64 字符串
//			String base64Img = Base64.getEncoder().encodeToString(serviceImgBytes);

			// 将转换后的 Base64 字符串设置给 p 的 serviceImg 字段
//			p.setServiceImg(base64Img);
			
			
	
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

	
	  Map<String, List<PriceList>> map = new HashMap();
	  map.put("data", priceLists);
	  return map;

	 }

}
