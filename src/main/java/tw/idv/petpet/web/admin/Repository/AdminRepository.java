package tw.idv.petpet.web.admin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.idv.petpet.web.admin.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
