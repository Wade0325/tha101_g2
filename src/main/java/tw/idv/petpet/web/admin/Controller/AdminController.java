package tw.idv.petpet.web.admin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.idv.petpet.web.admin.Repository.AdminRepository;
import tw.idv.petpet.web.admin.entity.Admin;

@Controller
//@RequestMapping("/AdminController")
public class AdminController {
	@Autowired
	private AdminRepository adminRepository;

	@GetMapping("/getAdmin")
	public String getAdmin() {

		return "/admin/adminLogin.html";
	}
	@GetMapping("/getall")
	public List<Admin> getAll() {
		return adminRepository.findAll();
	}
}
