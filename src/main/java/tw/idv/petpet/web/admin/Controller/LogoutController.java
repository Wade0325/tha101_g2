package tw.idv.petpet.web.admin.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.admin.BaseResponse;
import tw.idv.petpet.web.admin.ReturnCodeEnum;

@RestController
public class LogoutController {

	@PostMapping("/admin/logout")
	public BaseResponse Logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return new BaseResponse(ReturnCodeEnum.LOGOUT_SUCCESS);
	}
}
