package tw.idv.petpet.web.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.user.service.Impl.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@PostMapping("/user/ecpayCheckout")
	public String ecpayCheckout() {
		System.out.println("aaa");
		String aioCheckOutALLForm = orderService.ecpayCheckout();
		
		return aioCheckOutALLForm;
	}
}