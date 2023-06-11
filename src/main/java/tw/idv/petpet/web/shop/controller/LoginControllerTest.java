//package tw.idv.petpet.web.shop.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import tw.idv.petpet.web.shop.entity.Company;
//
//@RestController
//@CrossOrigin(origins = "http://127.0.0.1:5500")
//public class LoginControllerTest {
//
//		@GetMapping("/logintestget")
//	    public void testt() {
//	    	System.out.println("rerere");
//	    }
//	    @PostMapping("/logintest")
//	    public ResponseEntity<String> login(@RequestBody Company company, HttpSession session) {
//	        // 執行帳號密碼核對的邏輯
//	        if (isValidCredentials(company.getCompany_email(), company.getCompany_password())) {
//	        	System.out.println("000");
//	            // 登入成功，將使用者資料存入 Session
//	            session.setAttribute("Company", company);
//	            return ResponseEntity.ok("登入成功");
//	        } else {
//	            // 登入失敗，回傳錯誤訊息
//	        	System.out.println("007");
//	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("帳號或密碼錯誤");
//	        }
//	    }
//	    
//	    private boolean isValidCredentials(String username, String password) {
//	        // 實作帳號密碼核對的邏輯
//	        // 假設使用者資料存儲在資料庫中，這裡只做一個簡單的範例
//	        List<Company> users = getUserDataFromDatabase();
//	        System.out.println("123");
//	        // 遍歷使用者資料，檢查帳號和密碼是否匹配
//	        for (Company company : users) {
//	        	System.out.println("456");
//	            if (company.getCompany_email().equals(username) && company.getCompany_password().equals(password)) {
//	                // 帳號和密碼匹配
//	                return true;
//	            }
//	        }
//	        
//	        // 帳號和密碼不匹配
//	        return false;
//	    }
//	    
//	    // 從資料庫或其他儲存來源獲取使用者資料
//	    private List<Company> getUserDataFromDatabase() {
//	        // 實作從資料庫或其他儲存來源獲取使用者資料的邏輯
//	        // 假設users是一個包含使用者資料的List
//	        List<Company> users = new ArrayList<>();
//	        
//	        // 假設資料庫中有以下使用者資料
////	        users.add(new Company("user1", "password1"));
////	        users.add(new Company("user2", "password2"));
////	        users.add(new Company("user3", "password3"));
//	        
//	        return users;
//	    }
//	}
//
