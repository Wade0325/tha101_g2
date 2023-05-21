package tw.idv.petpet.web.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.member.entity.Member;
import tw.idv.petpet.web.member.service.MemberService;

@RestController
@RequestMapping("member/login")
public class LoginController {
	@Autowired
	private MemberService service;

	@GetMapping("{username}/{password}")
	public Member login(HttpServletRequest request, @PathVariable String username, @PathVariable String password) {
		Member member = new Member();
		if (username == null || password == null) {
			member.setMessage("無會員資訊");
			member.setSuccessful(false);
			return member;
		}

		member.setUsername(username);
		member.setPassword(password);
		member = service.login(member);
		if (member.isSuccessful()) {
			if (request.getSession(false) != null) {
				request.changeSessionId();
			}
			final HttpSession session = request.getSession();
			session.setAttribute("loggedin", true);
			session.setAttribute("member", member);
		}
		return member;
	}
}

