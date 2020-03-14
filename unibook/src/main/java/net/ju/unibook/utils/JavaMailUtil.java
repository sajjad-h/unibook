package main.java.net.ju.unibook.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMailUtil {

    public static void sendMail(String recipient, String code) throws Exception  {
        System.out.println("Message have to send!");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "hoosain.sajjad@gmail.com";
        String password = "@miamisajjad333";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recipient, code);

        Transport.send(message);
        System.out.println("Message sent successfully!");
    }

    public static Message prepareMessage(Session session, String myAccountEmail, String recipient, String code) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Forget Password!");
            message.setText("Security Code: " + code);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
