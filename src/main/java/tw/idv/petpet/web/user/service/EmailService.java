// Java Program to Illustrate Creation Of
// Service Interface
package tw.idv.petpet.web.user.service;

import tw.idv.petpet.web.user.entity.EmailDetails;

public interface EmailService {

	String sendSimpleMail(EmailDetails details);

	String sendMailWithAttachment(EmailDetails details);
	
	String sendForgotMail(EmailDetails details);

	String checkVerifyText(String verifyText, String userAccount);
}



