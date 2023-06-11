package tw.idv.petpet.web.shop.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shop.dao.CompanyRepository;
import tw.idv.petpet.web.shop.dao.OrderDetailRepository;
import tw.idv.petpet.web.shop.dao.OrderItemRepository;
import tw.idv.petpet.web.shop.entity.OrderDetail;
import tw.idv.petpet.web.shop.entity.OrderItem;
import tw.idv.petpet.web.shop.entity.Product;

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
	@PostMapping("/OrderIteminserttwo") // 新增訂單
	public String inserttwo(@RequestBody MergeData mergeData) {
		
		OrderItem data1 = mergeData.getData1();
		OrderDetail data2 = mergeData.getData2();
		Timestamp now = new Timestamp(System.currentTimeMillis());
		data2.setOrder_date(now);
		String cleanString = removeSymbols(now.toString());
		data2.setOrder_number(cleanString);
		System.out.println(cleanString);
		orderItemRepository.save(data1);
		orderDetailRepository.save(data2);
		return "測試OrderItem-insert";
	}
	
	//訂單查詢
	@GetMapping("/OrderItemSelect/{CompanyId}")
	public List<OrderItem> read(@PathVariable Integer CompanyId) {

		List<OrderItem> items = orderItemRepository.findByCompanyId(CompanyId);
		return items;
	}
	

	public static String removeSymbols(String timestampString) {
        LocalDateTime dateTime = LocalDateTime.parse(timestampString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        String cleanString = dateTime.toString().replaceAll("[^\\d\\s]", "");
        return cleanString;
    }
	


}
class MergeData {
    private OrderItem data1;
    private OrderDetail data2;
	public OrderItem getData1() {
		return data1;
	}
	public void setData1(OrderItem data1) {
		this.data1 = data1;
	}
	public OrderDetail getData2() {
		return data2;
	}
	public void setData2(OrderDetail data2) {
		this.data2 = data2;
	}
    
    
}

