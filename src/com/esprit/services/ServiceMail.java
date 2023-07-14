package com.esprit.services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceMail {

    public static void sendMail(String recipient, String subject, String body) {
        System.out.println("Preparing to send email...");

        // SMTP configuration parameters
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS encryption
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Your Gmail email address and password
        final String myEmail = "findjobreply@gmail.com";
        final String password = "pjwzsenustgioixb";

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, password);
            }
        });

        try {
            // Create the message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);

            // Send the message
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            System.out.println("Failed to send email. Error message: " + e.getMessage());
        }
    }

    public static void sendMailO(String recipient, String object, String msg) throws MessagingException {
        System.out.println("Preparing to send email...");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS encryption
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAdr = "findjobreply@gmail.com";
        String password = "vwzjqneictcidlgm";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAdr, password);
            }
        });

        Message message = prepareMessage(session, myAdr, recipient, object, msg);
        Transport.send(message);
        System.out.println("Email sent successfully!");
    }

    private static Message prepareMessage(Session session, String myAdr, String recipient, String object, String msg) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAdr));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(object);
            message.setText(msg);
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(ServiceMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
