package tw.idv.petpet.web.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.user.entity.User;
import tw.idv.petpet.web.user.service.UserService;

@RestController
@RequestMapping("/user/userController")
public class UserController {

	@Autowired
	private UserService userService;

	String userAccount;

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		System.out.println("進入Controller 執行 register 方法成功");
		userService.register(user);
		return user;
	}

//	@GetMapping("/findUser")
//	public String findUser() {
//		List<User> user = new ArrayList<User>();
//		user = userRepository.findAll();
//		
//		for (int i = 0; i < user.size(); i++) {
//			System.out.println(user.get(i).getUserTel());
//			userAccount = user.get(i).getUserTel();
//		}
//		return userAccount;
//	}

	@GetMapping("/findById/{userId}")
	public User findEmailById(@PathVariable Integer userId) {
		System.out.println("執行 findEmailById 方法成功");
		return userService.findById(userId);
	}

	@PostMapping("/login")
	public User login(@RequestBody User user) {
		System.out.println("執行 login 方法成功");
		userService.login(user);
		return user;
	}

}
