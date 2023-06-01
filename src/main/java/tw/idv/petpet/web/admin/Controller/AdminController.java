package tw.idv.petpet.web.admin.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.admin.Entity.AdminEntity;
import tw.idv.petpet.web.admin.Repository.AdminRepository;


@RestController
public class AdminController {
	@Autowired
	private AdminRepository adminRepository;

	@PostMapping("/admin")
	public AdminEntity createAdmin(@RequestBody AdminEntity adminEntity) {
		adminEntity = adminRepository.save(adminEntity);
		System.out.println("新增Admin資料成功");
		return adminEntity;
	}

	@GetMapping("/admin/all")
	public List<AdminEntity> getAdminAll() {
		List<AdminEntity> list = adminRepository.findAll();
		System.out.println("查詢Admin全部資料成功");
		return list;
	}

	@GetMapping("/admin/{adminId}")
	public Optional<AdminEntity> getAdminById(@PathVariable Integer adminId) {
		Optional<AdminEntity> optional = adminRepository.findById(adminId);
		System.out.println("查詢" + adminId + "資料成功");
		return optional;
	}
	
	@DeleteMapping("/admin/{adminId}")
	public void deleteAdminById(@PathVariable Integer adminId) {
		adminRepository.deleteById(adminId);
		System.out.println("刪除Admin資料成功");
	}
}
