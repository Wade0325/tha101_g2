package tw.idv.petpet.web.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.user.entity.User;
import tw.idv.petpet.web.user.service.UserService;


@RestController
@RequestMapping("user/register")
public class RegisterController {
	
	@Autowired
	@Qualifier("UserServiceImpl")
	private UserService service;

	@PostMapping
	public User register(@RequestBody User user) {
		if (user == null) {
			user = new User();
			user.setMessage("無會員資訊");
			user.setSuccessful(false);
			return user;
		}
		
		System.out.println("register controller收到");
		return service.register(user);
	}
}
