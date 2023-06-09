package tw.idv.petpet.web.shop.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shop.dao.CompanyRepository;
import tw.idv.petpet.web.shop.dao.OrderDetailRepository;
import tw.idv.petpet.web.shop.dao.OrderItemRepository;
import tw.idv.petpet.web.shop.entity.OrderDetail;
import tw.idv.petpet.web.shop.entity.OrderItem;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class OrderItemContorller {

	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	
	@PostMapping("/OrderIteminsert") // 新增訂單
	public String insert(@RequestBody OrderItem oredrItem) {
		 orderItemRepository.save(oredrItem);
		 
		return "測試OrderItem-insert";
	}
//	@PostMapping("/OrderIteminsert") // 新增訂單
//	public String insert(@RequestBody OrderDetail orderDetail) {
//		orderDetailRepository.save();
//		 
//		return "測試OrderItem-insert";
//	}
	
	

}


