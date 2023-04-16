package org.geekster;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class HandleMail {
    void sendMail() {
        // host : gmail is smtp
        String host = "smtp.gmail.com";


        Properties prop = System.getProperties();
        System.out.println(prop);
        //set properties
        prop.put("mail.smtp.host",host);
        prop.put("mail.smtp.port","465");
        prop.put("mail.smtp.ssl.enable","true");
        prop.put("mail.smtp.auth","true");

        // session
        Session mailSession = Session.getInstance(prop, new MailAuthenticator());

        // create the message object

        MimeMessage mimeMessage = new MimeMessage(mailSession);
        try {
            //sender

            mimeMessage.setFrom(MailConstants.SENDER);
            // receiver
            mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(MailConstants.RECEIVERMAILADRESS));
         //subject
            mimeMessage.setSubject(MailConstants.SUBJECT);

            mimeMessage.setText(MailConstants.MESSAGE);

            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
