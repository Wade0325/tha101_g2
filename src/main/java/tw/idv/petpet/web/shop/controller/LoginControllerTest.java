package tw.idv.petpet.web.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shop.entity.Company;
import tw.idv.petpet.web.shop.service.companyService;
import tw.idv.petpet.web.user.entity.User;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class LoginControllerTest {

	@Autowired
	private companyService companyservice;
	
	@PostMapping("/companyshoplogin")
	public Company login(@RequestBody Company company, HttpSession session) {
		System.out.println("Controller 開始執行 login 方法");
		Company userSession = companyservice.login(company);
		if (userSession.isSuccessful()) {
			session.setAttribute("userAccount", userSession);
		}
		System.out.println("Controller 執行 login 方法成功");
		return userSession;
	}
	   
}