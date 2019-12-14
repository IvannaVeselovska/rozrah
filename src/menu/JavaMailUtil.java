package menu;


import javax.mail.*;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaMailUtil {
    public static void sendMail(String messageText) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String myAccount = "veselka19012001@gmail.com";
        String password = "1901vesiv";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount,password);
            }
        });

        String recepient = "ivanna.veselovska.knm.2018@lpnu.ua";
        Message message = prepareMessage(session,myAccount,recepient, messageText);

        Transport.send(message);

        System.out.println("Message was sent to " + recepient);
    }

    private static Message prepareMessage(Session session, String myAccount, String recepient, String messageText) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccount));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("New message from aplication");
            String htmlCode = "<h1> Java aplication error!! </h1> <br/> <h2><b>"+messageText+"</b></h2>";
            message.setContent(htmlCode,"text/html");
            return message;
        }catch(Exception ex){
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null;
    }
}
