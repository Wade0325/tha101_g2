package tw.idv.petpet.web.shop.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	@PostMapping("/shoptest1") // 種類測試
	public String inserttest(@RequestBody Categories cat) {
		System.out.println("test");
		cate.save(cat);

		return "測試insert";
	}

	@PostMapping("/shoptestinsert") // 新增商品
	public Product insert(@RequestBody Product product) {
		 Timestamp now = new Timestamp(System.currentTimeMillis());
	     product.setCreate_time(now);
		productRepository.save(product);
		return product;
	}


	@DeleteMapping("/shoptest/{shopId}")
	public String delete(@PathVariable Integer shopId) {

		productRepository.deleteById(shopId);

		return "測試delete";
	}

	@GetMapping("/shoptest/{shopId}")
	public Product read(@PathVariable Integer shopId) {
		System.out.println("test1243");
		Product product = productRepository.findById(shopId).orElse(null);
		return product;
	}
	
	@GetMapping("/shoptestall")
	public List<Product> getAllProducts() {
	    List<Product> products = productRepository.findAll();
	    return products;
	}


	@PutMapping("/shoptest/{shopId}")
	public String update(@PathVariable Integer shopId, @RequestBody Product product) {

		Product p = productRepository.findById(shopId).orElse(null);
		if (p != null) {

			p.setPro_name(product.getPro_name());
			productRepository.save(p);

			return "測試update";
		} else {
			return "資料庫中沒有此資料";
		}
	}

	// 分頁查詢
	@GetMapping("/shoptestall/{pageNumber}/{pageSize}")
	public Page<Product> getProductsByPage(@PathVariable int pageNumber, @PathVariable int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		return productRepository.findAll(pageable);
	}
	
	
	// 測試接收圖片
//	@PostMapping("/shoptest111") // 新增商品
//	public String insert(@RequestParam("product") String productJson,
//	        @RequestParam("images[]") List<MultipartFile> images) {
//	    // 解析並處理productJson，這裡假設productJson是JSON格式的商品數據
//	    Product product = new Gson().fromJson(productJson, Product.class);
//
//	    // 在這裡處理上傳的圖片，例如保存到文件系統或數據庫
//
//	    productRepository.save(product);
//	    return "測試insert";
//	}
//測試接收圖片Base64
//	@PostMapping("/shoptest111")  //新增商品
//	public String insert(@ModelAttribute Product product) {
//	    System.out.println("test");
//	    // 將base64編碼的圖片資料轉換為byte陣列
//	    byte[] serviceImgBytes = Base64.getDecoder().decode(product.getPro_pic1());
//	    // 將byte陣列存儲到Product物件的serviceImg屬性中
//	    product.setPro_pic1(serviceImgBytes);
//	    productRepository.save(product);
//	    return "測試insert";
//	}
}
