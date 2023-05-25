package tw.idv.petpet.web.admin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.idv.petpet.web.admin.Repository.AdminRepository;
import tw.idv.petpet.web.admin.entity.Admin;

@Controller
public class AdminController {
	@Autowired
	private AdminRepository adminRepository;

	@GetMapping("/getAdmin")
	public String getAdmin() {
		
//		System.out.println("123");
		return "admin/adminLogin";
	}
}
