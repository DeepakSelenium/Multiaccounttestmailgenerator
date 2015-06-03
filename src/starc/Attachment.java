package starc;

import java.io.File;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

/* This class extends the main swing class */
/* Function used to provide the attachment using browse dialog*/

public class Attachment extends Testdatageneration {

	public static void Setattachment() throws MessagingException {
		
		attachPart = new MimeBodyPart();
		String filename = Testdatageneration.path;
		DataSource source = new FileDataSource(filename);
		attachPart.setDataHandler(new DataHandler(source));
		attachPart.setFileName(new File(filename).getName());
		multipart.addBodyPart(attachPart);
		Logtextarea.append("[ Attachment present ]" + "\n");
	}
}
