package tw.idv.petpet.web.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public User register(@RequestBody User user, HttpSession session) {
		System.out.println("Controller 開始執行 register 方法");
		userService.register(user);
		System.out.println("Controller 執行 register 方法成功");
		return user;
	}

	@GetMapping("/getUser")
	public User getUser(User user, HttpSession session) {
		User userSession = (User) session.getAttribute("userAccount");
		if (userSession.isLogin()) {
			System.out.println("Controller 執行 getUser 方法成功");
			return (User) session.getAttribute("userAccount");
		} else {
			userSession.setLogin(false);
			return userSession;
		}
	}

	@PostMapping("/login")
	public void login(@RequestBody User user, HttpSession session) {
		System.out.println("Controller 開始執行 login 方法");
		User userSession = userService.login(user); // return
		if (userSession.isSuccessful()) {
			session.setAttribute("userAccount", userSession);
		}
		System.out.println("Controller 執行 login 方法成功");
	}

	@PutMapping("/update")
	public User update(@RequestBody User user, HttpSession session) {
		User userSession = (User) session.getAttribute("userAccount");
		if (userSession.isLogin()) {
			System.out.println("Controller 開始執行 update 方法");
			userService.update(user); // (更新值,舊的使用者)
			System.out.println("Controller 執行 update 方法成功");
			return userSession;
		} else {
			user.setLogin(false);
			return userSession;
		}
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
