// Java Program to Illustrate Creation Of
// Service implementation class
package tw.idv.petpet.web.user.service.Impl;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
// Importing required classes
import tw.idv.petpet.web.user.entity.EmailDetails;
import tw.idv.petpet.web.user.entity.User;
import tw.idv.petpet.web.user.service.EmailService;
import tw.idv.petpet.web.user.service.UserService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UserService userService;

	@Value("${spring.mail.username}")
	private String sender;

	private static void redisVerifiCode(String userAccount,String verifiCode) {
		Jedis jedis = new Jedis("localhost", 6379);
		jedis.lpush(userAccount, verifiCode); // 左側插入
		jedis.expire("test", 10);
		jedis.close();
	}
	
	// Method 1
	// To send a simple email
	public String sendSimpleMail(EmailDetails details) {

		// Try block to check for exceptions
		try{
			 // Creating a simple mail message
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			String userAccount = details.getRecipient();
			String verifiCode = getAuthCode(); // 取得驗證信密碼
			redisVerifiCode(userAccount,verifiCode);
			
			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());

			mailMessage.setText(verifiCode);
			mailMessage.setSubject("註冊驗證信");

			System.out.println(details.getRecipient());
			
			// Sending the mail
			javaMailSender.send(mailMessage);
			return "Mail send successful...";
		}

		// Catch block to handle the exceptions
		catch (Exception e) {
			return "Error while Sending Mail";
		}
	}

	public String sendForgotMail(EmailDetails details) {

		// Try block to check for exceptions
		try {
			// Creating a simple mail message
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient()); // 目的地信箱

			String randonNewPassword = getAuthCode(); // 取得隨機新密碼
			mailMessage.setText(randonNewPassword);
			mailMessage.setSubject("新密碼");

			userService.update(details.getRecipient(), randonNewPassword);

			// Sending the mail
			javaMailSender.send(mailMessage);
			return "Mail send successful...";
		}

		// Catch block to handle the exceptions
		catch (Exception e) {
			return "Error while Sending Mail";
		}
	}

	// Method 2
	// To send an email with attachment
	public String sendMailWithAttachment(EmailDetails details) {
		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getRecipient());
			mimeMessageHelper.setText(details.getMsgBody());
			mimeMessageHelper.setSubject(details.getSubject());

			// Adding the attachment
			FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));

			mimeMessageHelper.addAttachment(file.getFilename(), file);

			// Sending the mail
			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully";
		}

		// Catch block to handle MessagingException
		catch (MessagingException e) {

			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}

	@Override
	public String checkVerifyText(String verifyText, String userAccount) {
		Jedis jedis = new Jedis("localhost", 6379);
		System.out.println(userAccount);
		List<String> list = jedis.lrange(userAccount, 0, 0); // key:使用者信箱
		jedis.close();
		System.out.println(verifyText);
		System.out.println(list.get(0));
		if(verifyText.equals(list.get(0))) {
			String status = "true"; 
			return status;
		}else {
			String status = "false"; 
			return status;
		}
	}

	public static String getAuthCode() {
		String verifiCode = "";
		// 用亂數決定第i個位置產生英文大寫還是小寫還是數字
		for (int i = 0; i < 8; i++) {
			int flag = (int) (Math.random() * 3 + 1); // 產生1,2,3
			// 產生A-Z
			if (flag == 1) {
				for (int j = 0; j < 1; j++) {
					verifiCode += (char) (Math.random() * 26 + 65);
				}
			}
			// 產生a-z
			if (flag == 2) {
				for (int j = 0; j < 1; j++) {
					verifiCode += (char) (Math.random() * 26 + 97);
				}
			}
			// 產生0-9
			if (flag == 3) {
				for (int j = 0; j < 1; j++) {
					verifiCode += (int) (Math.random() * 9);
				}
			}
		}
		return verifiCode;
	}

}
