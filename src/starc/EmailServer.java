package starc;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

/*
 * This is main class responsible for sending the email.
 * 
 * 
 * 
 */

public class EmailServer extends Testdatageneration {

	public static Session session;

	public static void ActualSend() throws IOException {

		String to = Tomailid;
		props = new Properties();

		if (Gmail) {
			System.out.println("Under gmail flag");
			Serversettings.Gmailserver();
			System.out.println("Gmail function called");
		} else if (Mobdev1) {
			System.out.println("Under mobdev1 flag");
			Serversettings.Mobdev1server();
			System.out.println("Mobdev 1 function called");
		} else if (Yahoo) {
			System.out.println("Under yahoo flag");
			Serversettings.Yahooserver();
			System.out.println("yahoo function called");
		} else if (Mail) {
			System.out.println("Under Mail flag");
			Serversettings.Mailserver();
			System.out.println("Mail function called");
		} else if (Hotmail) {
			System.out.println("Under HotMail flag");
			Serversettings.Hotmailserver();
			System.out.println("HotMail function called");
		} else if (Default) {
			Logtextarea
					.append("By default Gmail server to be connected" + "\n");
			Serversettings.Gmailserver();
			System.out.println("Default gmail function called");
		}

		// props.put("mail.smtp.auth", "true");
		Authenticator authenticator = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};
		session = Session.getInstance(props, authenticator);
		session.setDebug(true);

		try {

			Transport transport = session.getTransport();
			message = new MimeMessage(session);
			message.addHeader("Content-type", "text/HTML; charset=UTF-8");
			message.addHeader("format", "flowed");
			message.addHeader("Content-Transfer-Encoding", "8bit");
			message.setSentDate(new Date());
			multipart = new MimeMultipart();
			message.setFrom(new InternetAddress(username));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			if (isEditable) {
				message.setSubject(subjectisavailable);
			}

			if (isLengthavailable) {
				message.setSubject("Mail subject" + " "
						+ Counter.generateSessionKey(Mailsubjectlenght) + " "
						+ "Identification number:-"
						+ +Randomnumbergenerator.generaterandomnumber());

			}
			if (issubjectlengthnotavailable) {
				message.setSubject("Mail subject" + " "
						+ Counter.generateSessionKey(Mailsubjectlenght) + " "
						+ "Identification number:-"
						+ Randomnumbergenerator.generaterandomnumber());
			}

			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(message, "UTF-8");
			// messageBodyPart.setContent(message, "text/html");

			if (isbodycontentnotavailable) {
				messageBodyPart.setText("");

			} else if (isbodycontentavailable) {
				messageBodyPart.setText("Actual message:-" + " "
						+ Counter.generateSessionKey(MessageBody) + " "
						+ "Identification number:-"
						+ Randomnumbergenerator.generaterandomnumber());

			}

			if (path == null) {
				Logtextarea.append("[ No attachment ]" + "\n");
			} else {
				Attachment.Setattachment();
			}

			if (inlinepath == null) {
				Logtextarea.append("[ No inline attachment ]" + "\n");
			} else {
				Inlineattachment.Attachasinline();
			}
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);

			transport.connect();
			transport.sendMessage(message,
					message.getRecipients(Message.RecipientType.TO));
			transport.close();

			Logtextarea.append("Message sent successfully" + "\n");

		} catch (MessagingException e) {
			/*
			 * Gmail=false; Mobdev1=false; Yahoo=false; Mail=false;
			 * Hotmail=false;
			 */
			JOptionPane.showMessageDialog(frmKarna, "Mails sending failed",
					"Task not completed", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e.fillInStackTrace());
		}

	}

}