package tw.idv.petpet.web.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.petpet.web.user.dao.UserRepository;
import tw.idv.petpet.web.user.entity.User;

@Service
@Transactional
public class UserServiceRepo {

	@Autowired
    private UserRepository userRepository;
	
	public  void saveUser(User user){
        userRepository.save(user);
    }
}
