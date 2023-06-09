package tw.idv.petpet.web.shop.dao;

import org.springframework.data.repository.CrudRepository;

import tw.idv.petpet.web.shop.entity.OrderItem;
import tw.idv.petpet.web.shop.entity.Product;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer>{

}
