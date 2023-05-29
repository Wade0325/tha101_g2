package tw.idv.petpet.web.product.dao;

import org.springframework.data.repository.CrudRepository;

import tw.idv.petpet.web.product.entity.Categories;
import tw.idv.petpet.web.product.entity.Product;

public interface CategoriesRepository extends CrudRepository<Categories, Integer>{

}
