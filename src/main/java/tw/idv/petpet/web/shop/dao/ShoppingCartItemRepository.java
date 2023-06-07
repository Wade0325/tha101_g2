package tw.idv.petpet.web.shop.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import tw.idv.petpet.web.shop.entity.ShoppingCartItem;

public interface ShoppingCartItemRepository extends CrudRepository<ShoppingCartItem, Integer>{
	
	
	List<ShoppingCartItem> findAll();
}
