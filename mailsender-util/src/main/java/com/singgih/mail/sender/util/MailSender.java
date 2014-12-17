package com.singgih.mail.sender.util;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.google.common.base.Joiner;
import com.google.common.base.Stopwatch;

public class MailSender {
	Logger log = Logger.getLogger("com.singgih.mail.sender");
	private Session session;
	private Stopwatch stopwatch;
	
	
	public MailSender(String userName, String password, Properties properties) {
		session = Session.getInstance(properties, new MailAuthenticator(userName, password));
	}

	protected void startTimer() {
		stopwatch = new Stopwatch().start();
	}

	protected void stopTimer() {
		log.debug("executed on " + (stopwatch.elapsed(TimeUnit.MILLISECONDS)) + " ms");
	}
	
	public int  sendMail(String from, String recipient, String subject, String message) {
		String[] recipients = new String[] { recipient };
		return sendMail(from, recipients, null, null, subject, message, null);
	}

	public int  sendMail(String from, String[] recipients, String subject, String message) {
		return sendMail(from, recipients, null, null, subject, message, null);
	}

	public int  sendMail(String from, String recipient, String subject, String message, String attachmentPath) {
		String[] recipients = new String[] { recipient };
		return sendMail(from, recipients, null, null, subject, message, null);
	}

	public int sendMail(String from, String[] recipients, String[] ccs, String[] bccs, String subject, String messageContent, String[] attachmentPath) {
		int returnType;
		startTimer();
		log.debug("try to send mail with data : ");
		log.debug("  from : "+from);
		log.debug("  recipient : "+Joiner.on(',').join(Arrays.asList(recipients)));
		log.debug("  cc : "+Joiner.on(',').join(Arrays.asList(ccs==null?new String[]{}:ccs)));
		log.debug("  bcc : "+Joiner.on(',').join(Arrays.asList(bccs==null?new String[]{}:bccs)));
		log.debug("  subject : "+subject);
		log.debug("  message content : "+messageContent);
		log.debug("  attachment path : "+Joiner.on(',').join(Arrays.asList(attachmentPath==null?new String[]{}:attachmentPath)));
		
		MimeMessage mimeMessage = new MimeMessage(session);
		try {
			mimeMessage.setFrom(new InternetAddress(from));

			InternetAddress[] internetAddressRecipient = new InternetAddress[recipients.length];
			for (int i = 0; i < recipients.length; i++) {
				internetAddressRecipient[i] = new InternetAddress(recipients[i]);
			}
		
			mimeMessage.setRecipients(RecipientType.TO, internetAddressRecipient);
			
			if(ccs != null && ccs.length > 0){
				InternetAddress[] internetAddressCC = new InternetAddress[ccs.length];
				for (int i = 0; i < ccs.length; i++) {
					internetAddressCC[i] = new InternetAddress(ccs[i]);
				}
				mimeMessage.setRecipients(RecipientType.CC, internetAddressCC);
			}
			
			if(bccs != null && bccs.length > 0){
				InternetAddress[] internetAddressBCC = new InternetAddress[bccs.length];
				for (int i = 0; i < bccs.length; i++) {
					internetAddressBCC[i] = new InternetAddress(bccs[i]);
				}
				mimeMessage.setRecipients(RecipientType.BCC, internetAddressBCC);
			}
			
			mimeMessage.setSubject(subject);

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(messageContent, "text/html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
 
			if (attachmentPath != null) {
				for (int i = 0; i < attachmentPath.length; i++) {
					messageBodyPart = new MimeBodyPart();
					String filename = attachmentPath[i];
					DataSource source = new FileDataSource(filename);
					messageBodyPart.setDataHandler(new DataHandler(source));
					messageBodyPart.setFileName(filename);
					multipart.addBodyPart(messageBodyPart);
				}
			}

			mimeMessage.setContent(multipart);
			Transport.send(mimeMessage);
			log.info("Message sent successfully");
			returnType = 0;
		} catch (MessagingException fuckingException) {
			log.error("Failed to send message, error : "+ fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();		
			returnType = -1;
		}
		stopTimer();
		return returnType;
	}
}
