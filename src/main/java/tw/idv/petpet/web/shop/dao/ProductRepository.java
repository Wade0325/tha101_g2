package tw.idv.petpet.web.shop.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tw.idv.petpet.web.shop.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

	List<Product> findAll();
	Page<Product> findAll(Pageable pageable);
	
	@Query(value = "DELETE FROM Product WHERE pro_name = ?1",nativeQuery = true)
	@Modifying
	Integer deleteByName(String proName);
}
