package tw.idv.petpet.web.shop.dao;

import org.springframework.data.repository.CrudRepository;

import tw.idv.petpet.web.shop.entity.OrderDetail;
import tw.idv.petpet.web.shop.entity.OrderItem;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Integer>{

}
