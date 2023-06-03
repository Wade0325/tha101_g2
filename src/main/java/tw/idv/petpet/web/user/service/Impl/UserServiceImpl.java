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
        String str = userRepository.findByAccount(user.getUserAccount());

        if (str != null) {
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
    public String login(User user) {
        String str = userRepository.login(user.getUserAccount(), user.getUserPassword());
        if (str != null) {
            user.setSuccessful(true);
            System.out.println("登入成功");
        } else {
            user.setSuccessful(false);
            user.setMessage("帳號密碼錯誤");
            System.out.println("登入失敗");
        }
        return user.getMessage();
    }

}
