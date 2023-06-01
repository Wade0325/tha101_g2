package tw.idv.petpet.web.user.service.Impl;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.petpet.web.user.dao.UserRepository;
import tw.idv.petpet.web.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User register(User user) {
		return userRepository.save(user);
	}


}
