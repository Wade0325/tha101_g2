package tw.idv.petpet.web.shop.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tw.idv.petpet.web.shop.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

	List<Product> findAll();
	Page<Product> findAll(Pageable pageable);
	
	@Query(value = "DELETE FROM Product WHERE pro_name = ?1",nativeQuery = true)
	@Modifying
	Integer deleteByName(String proName);
	
//	@Query(value = "SELECT FROM Product WHERE cate_name = ?1",nativeQuery = true)
//	@Modifying
//	List<Product> findByCate_name(String cate_name);
	
	@Query(value = "SELECT * FROM Product WHERE cate_name = :cateName", nativeQuery = true)
    List<Product> findByCateName(@Param("cateName") String cateName);
	
	@Query(value = "SELECT * FROM Product WHERE pro_name LIKE %:proName%", nativeQuery = true)
	List<Product> findByproNameContaining(@Param("proName")String proName);
	
}
