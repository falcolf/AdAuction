package com.project.sendmail;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
public static void send(String to,String subject,String msg){

   String appmsg="<br><br>This is a computer generated email so please do not reply to this mail<br>For complaints or recommendations please mail us on complaints.adauction@gmail.com "; 
   String ack="<br>Sent From AdAuction<br>Thank YOu for using our website</p>";
   String finalmsg=msg+appmsg+ack+"<br></p>";
String user="noreply.adauction@gmail.com";//change accordingly
String pass="Myproject123";
/*
Properties props = new Properties();
props.put("mail.smtp.user", user);
props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.port", "465");
props.put("mail.smtp.ssl.enable", "true");
props.put("mail.smtp.debug", "true");
props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.socketFactory.port", "465");
props.put("mail.smtp.socketFactory.fallback", "false");
*/

Properties props = new Properties();
props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
props.put("mail.smtp.port", "587"); //TLS Port
props.put("mail.smtp.auth", "true"); //enable authentication
props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

Session session = Session.getDefaultInstance(props,
		 new javax.mail.Authenticator() {
  protected PasswordAuthentication getPasswordAuthentication() {
   return new PasswordAuthentication(user,pass);
   }
});
try {
 MimeMessage message = new MimeMessage(session);
 message.setFrom(new InternetAddress(user));
 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
 message.setSubject(subject);
 message.setContent(finalmsg , "text/html");
 
 //3rd step)send message
 //Transport trans=session.getTransport("smtps");
 //trans.connect("smtp.gmail.com",465,user,pass);
 //trans.sendMessage(message, message.getAllRecipients());
 //trans.close();
 Transport.send(message);

 } catch (MessagingException e) {
	throw new RuntimeException(e);
 }
	
}
}
