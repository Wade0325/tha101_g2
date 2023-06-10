package tw.idv.petpet.web.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import tw.idv.petpet.web.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT * FROM user where user_account = ?1", nativeQuery = true)
	User findByAccount(String userAccount);

	@Query(value = "SELECT * FROM user where user_account = ?1 and user_password = ?2", nativeQuery = true)
	User findByAccountAndPassword(String userAccount, String userPassword);

	@Modifying
	@Query(value = "UPDATE user SET user_name = ?1 WHERE user_id = ?2", nativeQuery = true)
	Integer updateUserName(String userName, Integer userId);

	@Modifying
	@Query(value = "UPDATE user SET user_tel = ?1 WHERE user_id = ?2", nativeQuery = true)
	Integer updateUserTel(String userTel, Integer userId);

	@Modifying
	@Query(value = "UPDATE user SET user_addr = ?1 WHERE user_id = ?2", nativeQuery = true)
	Integer updateUserAddr(String userAddr, Integer userId);

	@Modifying
	@Query(value = "UPDATE user SET user_password = ?1 WHERE user_account = ?2", nativeQuery = true)
	Integer updateUserPwd(String userPassword, String userAccount);

}
