package tw.idv.petpet.web.user.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.petpet.web.user.dao.UserRepository;
import tw.idv.petpet.web.user.entity.User;
import tw.idv.petpet.web.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User register(User user) {
		System.out.println("執行JPA save");
		return userRepository.save(user);
	}


	@Override
	public User findById(Integer userid) {
		System.out.println("執行JPA findById");
		return userRepository.findById(userid).orElse(null);
	}
	
}
