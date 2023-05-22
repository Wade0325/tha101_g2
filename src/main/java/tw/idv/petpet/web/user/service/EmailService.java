// Java Program to Illustrate Creation Of
// Service Interface
package tw.idv.petpet.web.user.service;

// Importing required classes
import tw.idv.petpet.web.user.entity.EmailDetails;

// Interface
public interface EmailService {

	// Method
	// To send a simple email
	String sendSimpleMail(EmailDetails details);

	// Method
	// To send an email with attachment
	String sendMailWithAttachment(EmailDetails details);
}
