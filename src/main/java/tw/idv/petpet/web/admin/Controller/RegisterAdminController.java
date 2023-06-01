package tw.idv.petpet.web.admin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.admin.Entity.AdminEntity;
import tw.idv.petpet.web.admin.Repository.AdminRepository;
import tw.idv.petpet.web.admin.dto.AdminRegisterVO;

@RestController
public class RegisterAdminController {

	@Autowired
	private AdminRepository adminRepository;

	@PostMapping("/admin/register")
	public Integer Register(@RequestBody AdminRegisterVO adminRegisterVO) {
		AdminEntity adminEntity = adminRepository.findByAdminAccount(adminRegisterVO.getAdminAccount());
		System.out.println("test1: " + adminRegisterVO.getAdminAccount());
		System.out.println("test1: " + adminRegisterVO.getAdminPassword());
		if (adminEntity == null) {
			adminEntity = new AdminEntity();
			System.out.println("test2: " + adminEntity);
			adminEntity.setAdminName(adminRegisterVO.getAdminName());
			System.out.println("test2: " + adminEntity.getAdminName());
			adminEntity.setAdminAccount(adminRegisterVO.getAdminAccount());
			System.out.println("test2: " + adminEntity.getAdminAccount());
			adminEntity.setAdminPassword(adminRegisterVO.getAdminPassword());
			System.out.println("test2: " + adminEntity.getAdminPassword());
			adminRepository.save(adminEntity);
			System.out.println("新增會員成功");
			return 1;
		} else {
			System.out.println("新增會員失敗");
			return 0;
		}
	}
}
