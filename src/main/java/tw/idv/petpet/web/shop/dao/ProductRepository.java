package tw.idv.petpet.web.shop.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import tw.idv.petpet.web.shop.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

	List<Product> findAll();
	Page<Product> findAll(Pageable pageable);
}
