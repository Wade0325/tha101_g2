package tw.idv.petpet.web.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shop.dao.ProductRepository;
import tw.idv.petpet.web.shop.entity.Product;

@RestController
public class NewProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/getProduct")
	public List<Product> getProduct() {
		System.out.println("aaa");
		String pro_name;
		List<Product> product = new ArrayList<Product>();
		product = productRepository.findAll();
		for (int i = 0; i < product.size(); i++) {
			System.out.println(product.get(i).getPro_name());
			pro_name = product.get(i).getPro_name();
		}
		return product;
	}

	@Transactional
	@DeleteMapping("/delProduct/{proName}")
	public String delete(@PathVariable String proName) {
		System.out.println("aaa");
		Integer i = productRepository.deleteByName(proName);
		System.out.println(i);
		return "delete";
	}
}
