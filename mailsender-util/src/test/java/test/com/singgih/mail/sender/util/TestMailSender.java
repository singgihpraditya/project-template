package test.com.singgih.mail.sender.util;

import java.util.Properties;

import org.junit.Test;

import com.singgih.mail.sender.util.MailSender;

public class TestMailSender {
	@Test
	public void testSendMail(){
		String username = "singgih";
		String password = "singgih";
		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");

		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "qsseeburger");
		props.put("mail.smtp.port", "25");

		MailSender mailSender = new MailSender(username, password,props);
		String[] recipients = {"singgih@qsseeburger"};
		String subject = "test send mail";
		String messageContent = "<h1>test</h1>";
		String[] attachmentPath = {"E:/app-log/VAMonitoring_1.txt","E:/app-log/VAMonitoring_2.txt"};
		int returnType = mailSender.sendMail(username, recipients, null, null, subject, messageContent, attachmentPath);
		System.out.println(returnType);
	}
}
