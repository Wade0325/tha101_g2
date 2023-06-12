package tw.idv.petpet.web.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tw.idv.petpet.web.shop.entity.OrderItem;
import tw.idv.petpet.web.shop.entity.Product;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer>{

	
//	@Query(value = "SELECT FROM Order_item WHERE company_id = ?1",nativeQuery = true)
	@Query(value = "SELECT oi FROM OrderItem oi WHERE oi.company_id = :companyId")
	List<OrderItem> findByCompanyId(@Param("companyId") Integer companyId);
	
//	@Query(value = "SELECT t1.company_id, u1.user_name FROM OrderItem t1 JOIN t1.user u1")
//	List<Object[]> findCompanyAndUserName();
//	
	
	
//	@Query(value = "SELECT oi.user.user_name FROM OrderItem oi WHERE oi.company_id = :companyId")
//	List<String> findUserNamesByCompanyId(@Param("companyId") Integer companyId);


}
