package tw.idv.petpet.web.shop.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shop.dao.CompanyRepository;
import tw.idv.petpet.web.shop.entity.Company;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CompanyControllor {

	@Autowired
	private CompanyRepository companyRepository;
	
	@PostMapping("/companyinsert") // 新增購物車商品
	public String insert(@RequestBody Company company) {
		 Timestamp now = new Timestamp(System.currentTimeMillis());
//		 company.setCreate_time(now);
		 companyRepository.save(company);
		return "測試insert";
	}
}
