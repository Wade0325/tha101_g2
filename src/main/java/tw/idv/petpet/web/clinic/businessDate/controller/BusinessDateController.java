package tw.idv.petpet.web.clinic.businessDate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.clinic.businessDate.entity.BusinessDate;
import tw.idv.petpet.web.clinic.businessDate.service.BusinessDateService;

@RestController
public class BusinessDateController {

	@Autowired
	private BusinessDateService service;

	@PostMapping("/business")
	public String insert(@RequestBody BusinessDate businessDate) {
		service.save(businessDate);
		return "執行create操作";
	}

	@PutMapping("/business/{businessSn}")
	public String update(@PathVariable Integer businessSn, @RequestBody BusinessDate businessDate) {
		BusinessDate businessDate1 = service.findById(businessSn).orElse(null);
		// businessSn、clinicId不可修改
		if (businessDate1 != null) {
			businessDate1.setVetSn(businessDate.getVetSn());
			businessDate1.setWeekDate(businessDate.getWeekDate());
			businessDate1.setMorningBusiness(businessDate.getMorningBusiness());
			businessDate1.setMorningAppointMax(businessDate.getMorningAppointMax());
			businessDate1.setAfternoonBusiness(businessDate.getAfternoonBusiness());
			businessDate1.setAfternoonAppointMax(businessDate.getAfternoonAppointMax());
			businessDate1.setNightBusiness(businessDate.getNightBusiness());
			businessDate1.setNightAppointMax(businessDate.getNightAppointMax());
			service.save(businessDate1);
			return "執行update操作";
		} else {
			return "資料不存在，操作失敗";
		}
	}

	@DeleteMapping("/business/{businessSn}")
	public String deleteById(@PathVariable Integer businessSn) {
		service.deleteById(businessSn);
		return "執行delete操作";
	}

	@GetMapping("/business/{businessSn}")
	public BusinessDate findById(@PathVariable Integer businessSn) {
		BusinessDate businessDate = service.findById(businessSn).orElse(null);
		return businessDate;
	}

	@PostMapping("/business/all")
	public List<BusinessDate> findAll() {
		List<BusinessDate> list = service.listAll();
		return list;
	}
}
