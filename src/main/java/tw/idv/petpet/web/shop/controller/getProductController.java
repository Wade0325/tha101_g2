package tw.idv.petpet.web.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shop.dao.ProductRepository;
import tw.idv.petpet.web.shop.entity.Product;

@RestController
public class getProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/getProduct")
	public Product getProduct() {
		String pro_name;
			List<Product> product = new ArrayList<Product>();
			product = productRepository.findAll();
			for (int i = 0; i < product.size(); i++) {
				System.out.println(product.get(i).getPro_name());
				pro_name = product.get(i).getPro_name();
			}
			return null;
	}
}
