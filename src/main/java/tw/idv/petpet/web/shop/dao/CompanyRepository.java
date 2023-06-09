package tw.idv.petpet.web.shop.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tw.idv.petpet.web.shop.entity.Company;
import tw.idv.petpet.web.shop.entity.Product;

public interface CompanyRepository extends CrudRepository<Company, Integer>{

	
}
