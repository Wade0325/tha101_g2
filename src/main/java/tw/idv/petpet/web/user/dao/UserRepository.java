package tw.idv.petpet.web.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.idv.petpet.web.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
