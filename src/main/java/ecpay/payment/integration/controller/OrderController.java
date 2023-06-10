//package ecpay.payment.integration.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import ecpay.payment.integration.service.OrderService;
//
//@RestController
//public class OrderController {
//	
//	@Autowired
//	OrderService orderService;
//
//	@PostMapping("/ecpayCheckout")
//	public String ecpayCheckout() {
//		System.out.println("aaa");
//		String aioCheckOutALLForm = orderService.ecpayCheckout();
//		
//		return aioCheckOutALLForm;
//	}
//}