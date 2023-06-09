package tw.idv.petpet.web.shop.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shop.dao.OrderDetailRepository;
import tw.idv.petpet.web.shop.entity.OrderDetail;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class OrderDetailController {

	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	
//	@PostMapping("/OrderDetailinsert") // 新增訂單
//	public String insertDetail(@RequestBody OrderDetail orderDetail) {
//
//		Timestamp now = new Timestamp(System.currentTimeMillis());
//		orderDetail.setOrder_date(now);
//		System.out.println(orderDetail.getOrder_date());
//		
//		orderDetailRepository.save(orderDetail);
//		return "測試OrderDetailinsert";
//	}
}
