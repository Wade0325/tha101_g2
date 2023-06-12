package tw.idv.petpet.web.shop.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shop.dao.OrderDetailRepository;
import tw.idv.petpet.web.shop.entity.OrderDetail;
import tw.idv.petpet.web.shop.entity.OrderItem;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class OrderDetailController {

	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	// 新增訂單
	@PostMapping("/OrderDetailinsert") 
	public String insertDetail(@RequestBody OrderDetail orderDetail) {

		Timestamp now = new Timestamp(System.currentTimeMillis());
		orderDetail.setOrder_date(now);
		
		
		orderDetailRepository.save(orderDetail);
		return "測試OrderDetailinsert";
	}
	
	//訂單查詢
		@GetMapping("/OrderDetailSelect/{CompanyId}")
		public List<OrderDetail> read(@PathVariable Integer CompanyId) {

			List<OrderDetail> items = orderDetailRepository.findByCompanyId(CompanyId);
			return items;
		}
	

	
}
