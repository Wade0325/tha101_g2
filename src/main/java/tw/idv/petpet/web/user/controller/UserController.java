package tw.idv.petpet.web.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.user.dao.UserRepository;
import tw.idv.petpet.web.user.entity.User;
import tw.idv.petpet.web.user.service.UserService;

@RestController
@RequestMapping("/user/userController")
public class UserController {
	
	@Autowired
	UserService userService;

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
//		for (int i = 0; i < user.size(); i++) {
//			System.out.println(user.get(i).getUserTel());
//			userAccount = user.get(i).getUserTel();
//		}
//		return userAccount;
//	}


	    @GetMapping("/findById")
	    public User findEmailById(HttpSession session) {
	        System.out.println("執行 findEmailById 方法成功");
	        User s =  (User)session.getAttribute("userAccount");
	       
	        return s;
	    }
	    
	    @PostMapping("/login")
	    public User login(@RequestBody User user ,HttpSession session) {
	        System.out.println("執行 login 方法成功");
	        userService.login(user);
	        if(user.isSuccessful()) {
	        	session.setAttribute("userAccount", user);
	        }
	        
	        return user;
	    }
        
	}
