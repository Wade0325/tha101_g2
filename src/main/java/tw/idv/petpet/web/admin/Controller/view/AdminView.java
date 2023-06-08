package tw.idv.petpet.web.admin.Controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//
@Controller
public class AdminView {
//	首頁
	@RequestMapping("/admin/index")
	public String adminIndex() {
		return "adminindex";
	}

//	商家檢舉
	@RequestMapping("/admin/reportfirm")
	public String adminReportFirm() {
		return "reportfirm";
	}
	
//	會員檢舉
	@RequestMapping("/admin/reportuser")
	public String adminReportUser() {
		return "reportuser";
	}
	
//	管理員註冊
	@RequestMapping("/admin/register")
	public String adminRegister() {
		return "adminlogin";
	}
//	
//	忘記密碼
	@RequestMapping("/admin/forgot")
	public String adminForgot() {
		return "forgotpss";
	}
//	
//	管理員登入
	@RequestMapping("/admin/login")
	public String adminLogin() {
		return "adminlogin";
	}

//	管理員編輯
	@RequestMapping("/admin/edit")
	public String adminedit() {
		return "adminedit";
	}
	
//	商家檢舉表單
	@RequestMapping("/reportfirmform")
	public String reportfirmform() {
		return "reportfirmform";
	}
	
//	會員檢舉表單
	@RequestMapping("/reportuserform")
	public String reportuserform() {
		return "reportuserform";
	}
//	
////	圖片上傳Form表單
//	@RequestMapping("/admin/upload")
//	public String picUpload() {
//		return "upload";
//	}
//	
////	聊天室
//	@RequestMapping("/chat")
//	public String chat() {
//		return "chat";
//	}
//	
////	測試圖片上傳Base64
//	@RequestMapping("/admin/upload2")
//	public String picUpload2() {
//		return "imgwithajax";
//	}
//	
////	測試聊天室
//	@RequestMapping("/chatModal")
//	public String chatwithmodal() {
//		return "chatModal";
//	}
//	
////	測試分頁
//	@RequestMapping("/admin/testpage")
//	public String page() {
//		return "testpage";
//	}
//	
////	測試會員清單
//	@RequestMapping("/list")
//	public String adminList() {
//		return "adminlist";
//	}
//
}
