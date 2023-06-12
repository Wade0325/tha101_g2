package tw.idv.petpet.web.shop.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tw.idv.petpet.web.shop.entity.Company;
import tw.idv.petpet.web.shop.entity.Product;
import tw.idv.petpet.web.user.entity.User;

public interface CompanyRepository extends CrudRepository<Company, Integer>{

	@Query(value = "SELECT * FROM Company where company_email = ?1 and company_pw = ?2", nativeQuery = true)
	Company findByAccountAndPassword(String companyemail, String userPassword);
}
