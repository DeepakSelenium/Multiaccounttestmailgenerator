package starc;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

/*
 * The function Attachasinline is responsible to sending the html content and image with 
 * cid with in mail body
 * 
 * 
 */

public class Inlineattachment extends Testdatageneration{
	
	public static void Attachasinline() throws IOException, MessagingException{
			
		MimeMultipart content = new MimeMultipart("related");
		 String cid = ContentIdGenerator.getContentId();
		   
		 // HTML part
		    MimeBodyPart textPart = new MimeBodyPart();
		    textPart.setText("<html><head>"
		      + "<title>This is not usually displayed</title>"
		      + "</head>\n"
		      + "<body><div><b>Hi there!</b></div>"
		      + "<div>Sending HTML in email is so <i>cool!</i> </div>\n"
		      + "<div>And here's an image: <img src=\"cid:"
		      + cid
		      + "\" /></div>\n" + "<div>I hope you like it!</div></body></html>", 
		      "US-ASCII", "html");
		    content.addBodyPart(textPart);
		    multipart.addBodyPart(textPart);
		    
		    // Image part
		    MimeBodyPart imagePart = new MimeBodyPart();
		    imagePart.attachFile(Testdatageneration.inlinepath);
		    imagePart.setContentID("<" + cid + ">");
		    imagePart.setDisposition(MimeBodyPart.INLINE);
		    content.addBodyPart(imagePart);
		    multipart.addBodyPart(imagePart);
		    Logtextarea.append("[ Inline attachment present ]" + "\n");
				
	}
}
