package tw.idv.petpet.web.user.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.petpet.web.user.dao.UserRepository;
import tw.idv.petpet.web.user.entity.User;
import tw.idv.petpet.web.user.service.UserService;

@Service
@Transactional
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
			return userRepository.save(userRegister);
		}
		System.out.println("Service 執行 findByAccount 方法成功");
		return null;
	}

	@Override
	public User getUser(User userSession) {
		return userRepository.findByAccount(userSession.getUserAccount());
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
			user.setSuccessful(false);
			user.setMessage("帳號密碼錯誤");
			System.out.println("登入失敗");
			return user;
		}
	}

	@Override
	public User update(User user) {
		User userUpdate = userRepository.findByAccount(user.getUserAccount());

		if (user.getUserName() != null) {
			userRepository.updateUserName(user.getUserName(), userUpdate.getUserId());
			return user;
		}

		if (user.getUserTel() != null) {
			userRepository.updateUserTel(user.getUserTel(), userUpdate.getUserId());
			return user;
		}

		if (user.getUserAddr() != null) {
			userRepository.updateUserAddr(user.getUserAddr(), userUpdate.getUserId());
			return user;
		}
		return user;
	}

	@Override
	public User updatePwd(User user, User userSession) {
		User userUpdatePwd = userRepository.findByAccountAndPassword(userSession.getUserAccount(),
				user.getUserPassword());
		System.out.println(userSession.getUserAccount());
		System.out.println(user.getUserNewPassword());
		if (userUpdatePwd != null) {
			userRepository.updateUserPwd(user.getUserNewPassword(), userSession.getUserAccount());
			user.setSuccessful(true);
			return user;
		} else {
			user.setSuccessful(false);
			return user;
		}
	}
}
