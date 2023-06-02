package tw.idv.petpet.web.admin.Controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
//	管理員註冊
	@RequestMapping("/admin/register")
	public String adminRegister() {
		return "adminlogin";
	}
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
	
//	商家檢舉
	@RequestMapping("/reportfirmform")
	public String reportfirmform() {
		return "reportfirmform";
	}
	
//	會員檢舉
	@RequestMapping("/reportuserform")
	public String reportuserform() {
		return "reportuserform";
	}
	
//	圖片上傳Test
	@RequestMapping("/upload")
	public String picUpload() {
		return "upload";
	}
	
//	圖片上傳Test
	@RequestMapping("/indextest")
	public String index() {
		return "indextest";
	}

}
