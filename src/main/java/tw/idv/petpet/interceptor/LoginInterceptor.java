package tw.idv.petpet.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import tw.idv.petpet.web.user.entity.User;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("經過攔截器");

		String uri = new String(request.getRequestURI());

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("MemberSession");

		// 已登入
		if (user != null) {
			System.out.println((user.getUserAccount() + " 訪問 " + uri));
			return true;
		}
		// 未登入
		else {
			return false;
		}
	}
}
