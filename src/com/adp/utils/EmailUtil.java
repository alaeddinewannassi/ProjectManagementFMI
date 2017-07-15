package com.adp.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class EmailUtil {

	 final String username = "alaxwannassi@gmail.com";
		final String password = "121212bh";
	
	 public void sendEmail(String login ,String email,String link) {
		 
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
				Date limitedDate= new Date();
				Calendar c = Calendar.getInstance(); 
				c.setTime(limitedDate); 
				c.add(Calendar.DATE, 1);
				limitedDate = c.getTime();
				message.setSubject("Account Activation");
				message.setText("Dear Sir  "+ login 
					+ ",\n\n you recently registered with FMI . "
					+ "To protect our serious users from spam accounts, it is very important that you "
					+ "validate your registration. To do so, please visit this URL : \n \n" +link+ " \n \n Make sure you do this not later than "+ limitedDate
					+". Otherwise your account will be deleted without any further notification."
					+"\n\n Thank you for your understanding,"
					+"\n FMI team");

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	 }

}
