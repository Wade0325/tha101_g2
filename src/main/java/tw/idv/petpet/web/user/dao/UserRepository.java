package tw.idv.petpet.web.user.dao;

import org.springframework.data.repository.CrudRepository;

import tw.idv.petpet.web.user.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	
}
