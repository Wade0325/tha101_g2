package tw.idv.petpet.web.user.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.petpet.web.user.dao.UserRepository;
import tw.idv.petpet.web.user.entity.User;
import tw.idv.petpet.web.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User register(User user) {
		System.out.println("Service 開始執行 register 方法");
		User userRegister = userRepository.findByAccount(user.getUserAccount());
		if (userRegister != null) {
			userRegister.setSuccessful(false);
			userRegister.setMessage("帳號已存在");
		} else {
			userRegister.setSuccessful(true);
			return userRepository.save(userRegister);
		}
		System.out.println("Service 執行 findByAccount 方法成功");
		return null;
	}

	@Override
	public User login(User user) {
		User userLogin = userRepository.findByAccountAndPassword(user.getUserAccount(), user.getUserPassword());
		if (userLogin != null) {
			userLogin.setSuccessful(true);
			userLogin.setLogin(true);
			System.out.println("登入成功");
			return userLogin;
		} else {
			userLogin.setSuccessful(false);
			userLogin.setMessage("帳號密碼錯誤");
			System.out.println("登入失敗");
			return null;
		}
	}

	@Override
	public User update(User user) {
		User userUpdate = userRepository.findByAccount(user.getUserAccount());
		userUpdate.getUserName();
		userUpdate.getUserId();
		userRepository.updateUserName(userUpdate.getUserName(), userUpdate.getUserId());
		return user;
	}
}
