package tw.idv.petpet.web.shop.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shop.dao.ShoppingCartItemRepository;

import tw.idv.petpet.web.shop.entity.ShoppingCartItem;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ShoppingCartItemController {

	@Autowired
	private ShoppingCartItemRepository shoppingCartItemRepository;
	
	@PostMapping("/cartproinsert") // 新增購物車商品
	public String insert(@RequestBody ShoppingCartItem shoppingcart) {
		 Timestamp now = new Timestamp(System.currentTimeMillis());
		 shoppingcart.setCreate_time(now);
	        shoppingCartItemRepository.save(shoppingcart);
		return "測試insert";
	}
	
	@GetMapping("/cartproall")
	public List<ShoppingCartItem> getAllProducts() {
	    List<ShoppingCartItem> shoppingcarts = shoppingCartItemRepository.findAll();
	    System.out.println(shoppingcarts.size());
	    return shoppingcarts;
	}
}
