// Java Program to Illustrate Creation Of
// Service implementation class
package tw.idv.petpet.web.user.service.Impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

// Importing required classes
import tw.idv.petpet.web.user.entity.EmailDetails;
import tw.idv.petpet.web.user.entity.User;
import tw.idv.petpet.web.user.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String sender;

	// Method 1
	// To send a simple email
	public String sendSimpleMail(EmailDetails details) {

		// Try block to check for exceptions
		try {
			// Creating a simple mail message
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			
			String verifiCode = getAuthCode(); // 取得驗證信密碼
		
			mailMessage.setText(verifiCode);
			details.setVerifiCode(verifiCode);
			
			mailMessage.setSubject("註冊驗證信");

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
