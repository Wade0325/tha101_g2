//package tw.idv.petpet.web.shop.Interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import tw.idv.petpet.web.shop.entity.Company;
//
//@Component
//public class AuthenticationInterceptor implements HandlerInterceptor{
//
//	 @Override
//	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//	        // 檢查 Session 中是否存在使用者資料，如果不存在，表示使用者未登入
//	        HttpSession session = request.getSession();
//	        Company company = (Company) session.getAttribute("company");
//	        if (company == null) {
//	            // 使用者未登入，導向登入頁面或返回未授權錯誤
//	            response.sendRedirect("/login"); // 假設登入頁面的 URL 是 /login
//	            return false;
//	        }
//	        
//	        // 使用者已登入，繼續處理請求
//	        return true;
//	    }
//	}
//
//
