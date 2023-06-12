package tw.idv.petpet.web.shop.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.shop.dao.CategoriesRepository;
import tw.idv.petpet.web.shop.dao.ProductRepository;
import tw.idv.petpet.web.shop.entity.Categories;
import tw.idv.petpet.web.shop.entity.Product;
@Transactional 
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/shoptest123")
	public void test() {
		System.out.println("test");
	}


	@PostMapping("/shoptestinsert") // 新增商品
	public Product insert(@RequestBody Product product) {
		 Timestamp now = new Timestamp(System.currentTimeMillis());
	     product.setCreate_time(now);
		productRepository.save(product);
		return product;
	}
	
	@DeleteMapping("/shoptest/{proName}")
	public String delete(@PathVariable String proName) {
		System.out.println("進入刪除方法");
		productRepository.deleteByName(proName);
		System.out.println("刪除方法");
		return "測試delete";
	}
	@GetMapping("/productselectca/{cateName}")
	public List<Product> selectByName(@PathVariable String cateName) {
		
		System.out.println(cateName);
		
		List<Product> cateProducts = productRepository.findByCateName(cateName);
		
		return cateProducts;
	}
	


	@DeleteMapping("/shopnumberdelete/{shopId}")
	public String delete(@PathVariable Integer shopId) {

		productRepository.deleteById(shopId);

		return "測試delete";
	}

	@GetMapping("/shoptest/{shopId}")
	public Product read(@PathVariable Integer shopId) {
		
		Product product = productRepository.findById(shopId).orElse(null);
		return product;
	}
	
	@GetMapping("/shoptestall")
	public List<Product> getAllProducts() {
	    List<Product> products = productRepository.findAll();
	    return products;
	}

	//修改
	@PutMapping("/shoptest/{shopId}")
	public Product update(@PathVariable Integer shopId, @RequestBody Product product) {

		Product p = productRepository.findById(shopId).orElse(null);
		if (p != null) {

			p.setPro_name(product.getPro_name());
			p.setPro_price(product.getPro_price());
			p.setPro_det(product.getPro_det());
			p.setPro_amount(product.getPro_amount());
			p.setCate_name(product.getCate_name());
			productRepository.save(p);

			return p;
		} else {
			return null;
		}
	}

	// 分頁查詢
	@GetMapping("/shoptestall/{pageNumber}/{pageSize}")
	public Page<Product> getProductsByPage(@PathVariable int pageNumber, @PathVariable int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		return productRepository.findAll(pageable);
	}
	
	
	//模糊查詢
	@GetMapping("/shopselvag/{proname}")
	public List<Product> read(@PathVariable String proname) {
	    List<Product> products = productRepository.findByproNameContaining(proname);
	    return products;
	}
	
	
}
