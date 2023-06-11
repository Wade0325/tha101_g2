package tw.idv.petpet.web.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tw.idv.petpet.web.shop.entity.OrderDetail;
import tw.idv.petpet.web.shop.entity.OrderItem;


public interface OrderDetailRepository extends CrudRepository<OrderDetail, Integer>{

	
//	@Query(value = "SELECT oi FROM OrderDetail oi WHERE oi.company_id = :companyId")
//	List<OrderDetail> findByCompanyId(@Param("companyId") Integer companyId);
	
	
	@Query(value = "SELECT oi FROM OrderDetail oi WHERE oi.company_id = :companyId")
	List<OrderDetail> findByCompanyId(@Param("companyId") Integer companyId);
}
