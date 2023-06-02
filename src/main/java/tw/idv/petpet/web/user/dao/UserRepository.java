package tw.idv.petpet.web.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.idv.petpet.web.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT user_account FROM user where user_account = ?1", nativeQuery = true)
	String findByAccount(String userAccount);
	
	@Query(value = "SELECT user_account FROM user where user_account = ?1 and user_password = ?2", nativeQuery = true)
	String login(String userAccount, String userPassword);

}
