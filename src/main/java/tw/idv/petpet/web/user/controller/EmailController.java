// Java Program to Create Rest Controller that
// Defines various API for Sending Mail
package tw.idv.petpet.web.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Importing required classes
import tw.idv.petpet.web.user.entity.EmailDetails;
import tw.idv.petpet.web.user.service.EmailService;

@RestController
public class EmailController {
	@Autowired
	private EmailService emailService;

	// Sending a simple Email
	@PostMapping("/user/sendMail")
	public String sendMail(@RequestBody EmailDetails details) {
		String status = emailService.sendSimpleMail(details);
		return status;
	}

	// Sending email with attachment
	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody EmailDetails details) {
		String status = emailService.sendMailWithAttachment(details);
		return status;
	}
	
	@PostMapping("/user/forgotMail")
	public String sendForgotMail(@RequestBody EmailDetails details) {
		System.out.println("Controller 開始執行 sendForgotMail 方法");
		String status = emailService.sendForgotMail(details);
		System.out.println("Controller 執行 sendForgotMail 方法成功");
		
		return status;
	}
}
