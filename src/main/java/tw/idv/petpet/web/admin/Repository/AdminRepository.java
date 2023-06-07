package tw.idv.petpet.web.admin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.idv.petpet.web.admin.Entity.AdminEntity;

<<<<<<< HEAD
=======


>>>>>>> jerry
@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {

	AdminEntity findByAdminAccountAndAdminPassword(String adminAccount, String adminPassword);

	AdminEntity findByAdminAccount(String adminAccount);

	AdminEntity findByAdminId(Integer adminId);
}
