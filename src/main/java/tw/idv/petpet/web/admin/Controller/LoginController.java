package tw.idv.petpet.web.admin.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.admin.BaseResponse;
import tw.idv.petpet.web.admin.ReturnCodeEnum;
import tw.idv.petpet.web.admin.Entity.AdminEntity;
import tw.idv.petpet.web.admin.Repository.AdminRepository;
import tw.idv.petpet.web.admin.dto.AdminLoginVO;

@RestController
public class LoginController {

	@Autowired
	private AdminRepository adminRepository;

	@PostMapping("/admin/login")
	public BaseResponse Login(@RequestBody AdminLoginVO adminLoginVO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("進入Login方法");
		System.out.println(adminLoginVO);
		AdminEntity adminEntity = adminRepository
				.findByAdminAccountAndAdminPassword(adminLoginVO.getAdminAccount(), adminLoginVO.getAdminPassword());

		if (adminEntity != null) {
			System.out.println("Session儲存會員資料");
			session.setAttribute("loginAdminEntity", adminEntity);
			System.out.println("Session Id: " + session.getId());
			return new BaseResponse(ReturnCodeEnum.LOGIN_SUCCESS);
		} else {
			return new BaseResponse(ReturnCodeEnum.LOGIN_FAIL);
		}
	}
}
