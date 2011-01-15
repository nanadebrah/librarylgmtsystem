/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Send email class
 * @author CuongNQ
 */
public class LibEmailSender {

    //Defined instance of LibEmailSender
    private static LibEmailSender instance = new LibEmailSender();

    /**
     * Static method get instance of LibProcedure
     */
    public static LibEmailSender getInstance() {
        return instance;
    }

    /**
     * Send a email with param
     * @param to
     * @param from
     * @param host
     * @param smtpPort
     * @param subject
     * @param body
     * @param fileAttachment
     * @param attachmentMimeType
     * @param username
     * @param password
     * @throws Exception
     */
    public void send(String to,
            String from,
            String host,
            String smtpPort,
            String subject,
            String body,
            String fileAttachment,
            String attachmentMimeType,
            String username,
            String password)
            throws Exception {

        // create some properties and get the default Session
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", smtpPort);
        //props.put("mail.debug", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = null;
        if (username != null && password != null) {
            props.put("mail.smtp.auth", "true");
            session = Session.getInstance(props,
                    new MyPasswordAuthenticator(username, password));
        } else {
            session = Session.getDefaultInstance(props, null);
        }

        // create a message
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        InternetAddress[] address = InternetAddress.parse(to, false);
        message.setRecipients(Message.RecipientType.TO, address);
        message.setSubject(subject);
        message.setSentDate(new Date());

        // create the message part
        MimeBodyPart messageBodyPart =
                new MimeBodyPart();

        //fill message
        messageBodyPart.setContent(body, "text/plain");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // Part two is attachment
        if (fileAttachment != null) {
            messageBodyPart = new MimeBodyPart();
            FileDataSource fds =
                    new FileDataSource(fileAttachment);
            messageBodyPart.setDataHandler(
                    new DataHandler(fds));
            messageBodyPart.setFileName("attatch.pdf");

            multipart.addBodyPart(messageBodyPart);
        }

        // Put parts in message
        message.setContent(multipart);

        // send the message
        Transport.send(message);

    }

    /**
     * Test connection to send email
     * @param host
     * @param smtpPort
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public boolean testEmail(
            String host,
            String smtpPort,
            String username,
            String password)
            throws Exception {

        // create some properties and get the default Session
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", smtpPort);
        //props.put("mail.debug", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = null;
        if (username != null && password != null) {
            props.put("mail.smtp.auth", "true");
            session = Session.getInstance(props,
                    new MyPasswordAuthenticator(username, password));
        } else {
            session = Session.getDefaultInstance(props, null);
        }
        Transport transport = session.getTransport("smtp");
        try {
            transport.connect();
            return transport.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            transport.close();
        }
        return false;
    }
}

/**
 * This is the authenticator for SMTP session
 */
class MyPasswordAuthenticator extends Authenticator {

    String user;
    String pw;

    public MyPasswordAuthenticator(String username, String password) {
        super();
        this.user = username;
        this.pw = password;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, pw);
    }
}
