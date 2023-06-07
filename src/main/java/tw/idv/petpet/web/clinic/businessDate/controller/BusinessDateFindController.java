package tw.idv.petpet.web.clinic.businessDate.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.clinic.businessDate.entity.BusinessDate;
import tw.idv.petpet.web.clinic.businessDate.service.BusinessDateService;

@RestController
public class BusinessDateFindController {

	@Autowired
	private BusinessDateService service;

	
	@GetMapping("/businessall")
	public Map<String, List<BusinessDate>> findAll() {
	    List<BusinessDate> list = service.listAll();
	    Map<String, List<BusinessDate>> map = new HashMap<>();
	    map.put("data", list);
	    return map;
	}

	
}

