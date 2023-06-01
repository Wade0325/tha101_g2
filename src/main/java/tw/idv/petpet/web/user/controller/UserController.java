package tw.idv.petpet.web.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.user.dao.UserRepository;
import tw.idv.petpet.web.user.entity.User;

@RestController
@RequestMapping("/userController")
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	String userAccount;
	@GetMapping("/findUser")
	public String findUser() {

		List<User> user = new ArrayList<User>();

		user = userRepository.findAll();

		for (int i = 0; i < user.size(); i++) {
			System.out.println(user.get(i).getUserTel());
			userAccount = user.get(i).getUserTel();
		}
		return userAccount;
	}

		@PostMapping("/createUser/{userAccount}")
		public User createUser(@RequestBody User user) {
			return userRepository.save(user);
		} // 其他请求处理方法... }

        @GetMapping("/findById/{userId}")
        public User findById(@PathVariable Integer userId) {
            return userRepository.findById(userId).orElse(null);
            
        }
		
	}
