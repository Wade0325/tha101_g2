package tw.idv.petpet.web.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shop.dao.CategoriesRepository;
import tw.idv.petpet.web.shop.dao.ProductRepository;
import tw.idv.petpet.web.shop.entity.Categories;
import tw.idv.petpet.web.shop.entity.Product;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductController {
	
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoriesRepository cate;
	
	
	@GetMapping("/shoptest123")
	public void test() {
		System.out.println("test");
	}
	
	@PostMapping("/shoptest1")  //種類測試
	public String inserttest(@RequestBody Categories cat) {
		System.out.println("test");
		cate.save(cat);
		
		return "測試insert";
	}
	
	@PostMapping("/shoptest111")  //新增商品
	public String insert(@RequestBody Product product) {
		System.out.println("test");
		productRepository.save(product);
		return "測試insert";
	}
	
	@DeleteMapping("/shoptest/{shopId}")
	public String delete(@PathVariable Integer shopId) {
		
		productRepository.deleteById(shopId);
		
		return "測試delete";	
	}
	
	
	
	
//	@PostMapping("/shoptest")
//	public String create(@RequestBody Product product) {
//		return "測試create";
//	}
	
//	@GetMapping("/shoptest/{shopId}")
//	public String read(@PathVariable Integer shopId) {
//		return "測試read";
//	}
//	
//	@PutMapping("/shoptest/{shopId}")
//	public String update(@PathVariable Integer shopId ,
//						 @RequestBody Product product) {
//		return "測試update";
//	}
//	
//	@DeleteMapping("/shoptest/{shopId}")
//	public String delete(@PathVariable Integer shopId) {
//		
//		return "測試delete";	
//	}
}
