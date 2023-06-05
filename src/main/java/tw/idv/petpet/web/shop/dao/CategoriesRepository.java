package tw.idv.petpet.web.shop.dao;

import org.springframework.data.repository.CrudRepository;


import tw.idv.petpet.web.shop.entity.Product;
import tw.idv.petpet.web.shop.entity.categories;

public interface CategoriesRepository extends CrudRepository<categories, Integer>{

}
