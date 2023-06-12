//package tw.idv.petpet.web.shop.Interceptor;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//	public class WebConfig implements WebMvcConfigurer {
//
//	    private final AuthenticationInterceptor authenticationInterceptor;
//
//	    public WebConfig(AuthenticationInterceptor authenticationInterceptor) {
//	        this.authenticationInterceptor = authenticationInterceptor;
//	    }
//
//	    @Override
//	    public void addInterceptors(InterceptorRegistry registry) {
//	        registry.addInterceptor(authenticationInterceptor)
//	                .addPathPatterns("/**") // 所有路徑都需要進行登入驗證
//	                .excludePathPatterns("/login"); // 登入頁面不需要進行驗證
//	    }
//	}
//
