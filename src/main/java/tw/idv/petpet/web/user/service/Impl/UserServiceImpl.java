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
        System.out.println("進入Service 執行 register 方法成功");
        String userAccount = userRepository.findByAccount(user).getUserAccount();

        if (userAccount != null) {
            user.setSuccessful(false);
            user.setMessage("帳號已存在");
        } else {
            user.setSuccessful(true);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User findById(Integer userid) {
        System.out.println("執行JPA findById");
        return userRepository.findById(userid).orElse(null);
    }
    

    @Override
    public User login(User user) {
        User userLogin = userRepository.login(user.getUserAccount(), user.getUserPassword());
        if (userLogin != null) {
            userLogin.setSuccessful(true);
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
	public User findByAccount(User user) {
		return userRepository.findByAccount(user);
	}

}
