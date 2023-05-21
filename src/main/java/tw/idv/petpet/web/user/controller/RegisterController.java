package tw.idv.petpet.web.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	private UserService service;

	@PostMapping
	public User register(@RequestBody User User) {
		if (User == null) {
			User = new User();
			User.setMessage("無會員資訊");
			User.setSuccessful(false);
			return User;
		}
		return service.register(User);
	}
}
