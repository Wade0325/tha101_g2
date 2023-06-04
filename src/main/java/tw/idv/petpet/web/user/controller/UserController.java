package tw.idv.petpet.web.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	UserService userService;

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		System.out.println("Controller 執行 register 方法成功");
		userService.register(user);
		return user;
	}

	@GetMapping("/findById")
	public User findById(User user, HttpSession session) {
		System.out.println("Controller 執行 findById 方法成功");
		return (User) session.getAttribute("userAccount");
	}

	@PostMapping("/login")
	public User login(@RequestBody User user, HttpSession session) {
		System.out.println("Controller 執行 login 方法成功");
		User userLogin = userService.login(user);
		if (userLogin.isSuccessful()) {
			session.setAttribute("userAccount", userLogin);
		}
		return userLogin;
	}
}

//		@GetMapping("/findUser")
//		public String findUser() {
//			List<User> user = new ArrayList<User>();
//			user = userRepository.findAll();
//			for (int i = 0; i < user.size(); i++) {
//				System.out.println(user.get(i).getUserTel());
//				userAccount = user.get(i).getUserTel();
//			}
//			return userAccount;
//		}
