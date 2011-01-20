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
 * 
 * @author CuongNQ
 */
public class LibEmailSender {

	// Defined instance of LibEmailSender
	private static LibEmailSender instance = new LibEmailSender();

	/**
	 * Static method get instance of LibEmailSender
	 */
	public static LibEmailSender getInstance() {
		return instance;
	}

	/**
	 * Send a email with param
	 * 
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
	public void send(String to, String from, String host, String smtpPort,
			String subject, String body, String fileAttachment,
			String attachmentMimeType, String username, String password)
			throws Exception {

		// create some properties and get the default Session
		Properties props = new Properties();
		props.put(Messages.getString("LibEmailSender.0"), host); //$NON-NLS-1$
		props.put(Messages.getString("LibEmailSender.1"), smtpPort); //$NON-NLS-1$
		// props.put("mail.debug", "true");
		props.put(Messages.getString("LibEmailSender.2"),
				Messages.getString("LibEmailSender.3")); //$NON-NLS-1$ 

		Session session = null;
		if (username != null && password != null) {
			props.put(Messages.getString("LibEmailSender.4"),
					Messages.getString("LibEmailSender.5")); //$NON-NLS-1$ 
			session = Session.getInstance(props, new MyPasswordAuthenticator(
					username, password));
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
		MimeBodyPart messageBodyPart = new MimeBodyPart();

		// fill message
		messageBodyPart
				.setContent(body, Messages.getString("LibEmailSender.6")); //$NON-NLS-1$

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// Part two is attachment
		if (fileAttachment != null) {
			messageBodyPart = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(fileAttachment);
			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setFileName(Messages.getString("LibEmailSender.7")); //$NON-NLS-1$

			multipart.addBodyPart(messageBodyPart);
		}

		// Put parts in message
		message.setContent(multipart);

		// send the message
		Transport.send(message);

	}

	/**
	 * Test connection to send email
	 * 
	 * @param host
	 * @param smtpPort
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean testEmail(String host, String smtpPort, String username,
			String password) throws Exception {

		// create some properties and get the default Session
		Properties props = new Properties();
		props.put(Messages.getString("LibEmailSender.8"), host); //$NON-NLS-1$
		props.put(Messages.getString("LibEmailSender.9"), smtpPort); //$NON-NLS-1$
		// props.put("mail.debug", "true");
		props.put(Messages.getString("LibEmailSender.10"),
				Messages.getString("LibEmailSender.11")); //$NON-NLS-1$ 

		Session session = null;
		if (username != null && password != null) {
			props.put(Messages.getString("LibEmailSender.12"),
					Messages.getString("LibEmailSender.13")); //$NON-NLS-1$ 
			session = Session.getInstance(props, new MyPasswordAuthenticator(
					username, password));
		} else {
			session = Session.getDefaultInstance(props, null);
		}
		Transport transport = session.getTransport(Messages
				.getString("LibEmailSender.14")); //$NON-NLS-1$
		try {
			transport.connect();
			return transport.isConnected();
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			transport.close();
		}
		return false;
	}
}

/**
 * This is the authenticator for SMTP session
 */
class MyPasswordAuthenticator extends Authenticator {

	/**
	 * Defined
	 */
	String user;
	String pw;

	/**
	 * Default constructor
	 * 
	 * @param username
	 * @param password
	 */
	public MyPasswordAuthenticator(String username, String password) {
		super();
		this.user = username;
		this.pw = password;
	}

	/**
	 * Create PasswordAuthentication
	 * 
	 * @return
	 */
	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, pw);
	}
}
