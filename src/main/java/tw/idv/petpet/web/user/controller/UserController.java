package tw.idv.petpet.web.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.user.dao.UserRepository;
import tw.idv.petpet.web.user.entity.User;

@RestController
@RequestMapping("/user/userController")
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	String userAccount;
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
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

        @GetMapping("/findById/{userId}")
        public User findEmailById(@PathVariable Integer userId) {
            return userRepository.findById(userId).orElse(null);   
        }
        
	}
