package tw.idv.petpet.web.admin.Controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.petpet.web.admin.Entity.AdminEntity;
import tw.idv.petpet.web.admin.Repository.AdminRepository;
import tw.idv.petpet.web.admin.dto.EmailVO;
import tw.idv.petpet.web.admin.service.MailService;
import tw.idv.petpet.web.admin.service.MailService2;



@RestController
public class EmailController {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	MailService2 mailService2;

	@Autowired
	private MailService mailService;

	@PostMapping("/sendEmail")
	public String sendEmail(@RequestBody EmailVO emailVO) {
		System.out.println(emailVO.getEmail());
		String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqretuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();
		Random rd = new Random();
		for (int i = 0; i < 6; i++) {
			int index = rd.nextInt(CHARACTERS.length());
			char word = CHARACTERS.charAt(index);
			sb.append(word);
		}
		String updatePass = sb.toString();
		mailService.sendMail(emailVO.getEmail(), "後台管理員", "請謹記此密碼" + updatePass + "唷!!別再忘記");
		return "Email sent successfully!";
	}

	@PostMapping("/sendEmail2")
	public ResponseEntity<String> sendEmail2(@RequestBody EmailVO emailVO, AdminEntity adminEntity) {
		AdminEntity adminCheck = adminRepository.findByAdminAccount(emailVO.getEmail());
		if (adminCheck != null) {
			String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqretuvwxyz0123456789";
			StringBuilder sb = new StringBuilder();
			Random rd = new Random();
			for (int i = 0; i < 6; i++) {
				int index = rd.nextInt(CHARACTERS.length());
				char word = CHARACTERS.charAt(index);
				sb.append(word);
			}
			String updatePass = sb.toString();
			adminEntity.setAdminId(adminCheck.getAdminId());
			adminEntity.setAdminName(adminCheck.getAdminName());
			adminEntity.setAdminAccount(adminCheck.getAdminAccount());
			adminEntity.setAdminPassword(updatePass);
			adminRepository.save(adminEntity);
			System.out.println(adminCheck.getAdminAccount() + "更改密碼完成");
			mailService2.sendEmail(emailVO.getEmail(), "後台管理員", "Hello!親愛【PETPET陪陪你】" + adminCheck.getAdminName()
					+ "用戶你好~	請使用此密碼【" + updatePass + "】登入，提醒你登入後請更改密碼，保障帳號密碼的權益");
			System.out.println("發送成功!!!");
			return ResponseEntity.ok("Email sent successfully!");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("查無此資料");
		}
	}
}
