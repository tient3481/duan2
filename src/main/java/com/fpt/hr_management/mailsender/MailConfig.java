package com.fpt.hr_management.mailsender;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.fpt.hr_management.daoImpl.authentication.AccountResetEntity;

public class MailConfig {
	protected AccountResetEntity mailInfo = new AccountResetEntity();

	class config {

		public static final String HOST_NAME = "smtp.gmail.com";
		public static final int SSL_PORT = 465;
		public static final int TSL_PORT = 587;

		public static final String APP_EMAIL = "anbvph06661@fpt.edu.vn";
		public static final String APP_PASSWORD = "cbksnzvgjclhspix";

	}

	public static int randomCode() {
		Random randomCode = new Random();
		return randomCode.nextInt(900000);
	}

	public void sendEmail(String emailReset) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", config.HOST_NAME);
		props.put("mail.smtp.socketFactory.port", config.SSL_PORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", config.SSL_PORT);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(config.APP_EMAIL, config.APP_PASSWORD);
			}
		});

		MimeMessage message = null;
		try {
			message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailReset));
			message.setSubject("Reset password system");
			int code = randomCode();
			message.setText("XTEL-INTERNAL notification to: " + emailReset
					+ ". Here is the password change code for your account:  " + code);
			try {
				Transport.send(message);
				System.out.println("Message sent successfully: " + mailInfo.getCode());
			} catch (Exception e) {
				e.printStackTrace();
			}
			mailInfo.setCode(code);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		MailConfig main = new MailConfig();
		main.sendEmail("anbvph06661@fpt.edu.vn");
	}

}
