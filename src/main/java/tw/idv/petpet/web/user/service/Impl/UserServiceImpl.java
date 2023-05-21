package tw.idv.petpet.web.user.service.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.petpet.web.user.dao.UserDao;
import tw.idv.petpet.web.user.entity.User;
import tw.idv.petpet.web.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao dao;
	
	@Transactional
	@Override
	public User register(User user) {
		if (user.getUserAccount() == null) {
			user.setMessage("帳號未輸入");
			user.setSuccessful(false);
			return user;
		}

		if (user.getUserPassword() == null) {
			user.setMessage("密碼未輸入");
			user.setSuccessful(false);
			return user;
		}

//		if (user.getUserName() == null) {
//			user.setMessage("暱稱未輸入");
//			user.setSuccessful(false);
//			return user;
//		}

		if (dao.selectByAccount(user.getUserAccount()) != null) {
			user.setMessage("帳號重複");
			user.setSuccessful(false);
			return user;
		}

		final int resultCount = dao.insert(user);
		if (resultCount < 1) {
			user.setMessage("註冊錯誤，請聯絡管理員!");
			user.setSuccessful(false);
			return user;
		}

		user.setMessage("註冊成功");
		user.setSuccessful(true);
		return user;
	}
}
