package tw.idv.petpet.web.product.dao;

import org.springframework.data.repository.CrudRepository;

import tw.idv.petpet.web.product.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
