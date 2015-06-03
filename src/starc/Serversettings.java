package starc;

public class Serversettings extends EmailServer{
	
	/*
	 * Function Gmailserver is used to send the mail using zimbrainbox84@gmail.com
	 * Function Mobdev1server is used to send the mail using mobdev1 server
	 */
	
	public static void Gmailserver(){
	    
		  props.setProperty("mail.smtp.host", "smtp.gmail.com");
		  props.setProperty("mail.transport.protocol", "smtp");
		  props.setProperty("mail.smtp.starttls.enable","true");
		  props.setProperty("mail.smtp.auth", "true");
		  props.setProperty("mail.smtp.socketFactory.class",  
		            "javax.net.ssl.SSLSocketFactory");
		  props.setProperty("mail.smtp.socketFactory.port", "465");  
		  props.setProperty("mail.smtp.port", "465");  
	}
	
	public static void Mobdev1server(){
		  props.setProperty("mail.smtp.host", "mobdev1.zimbra.com");
		  props.setProperty("mail.transport.protocol", "smtp");
		  props.setProperty("mail.smtp.starttls.enable","true");
		  props.setProperty("mail.smtp.auth", "true");
		  props.setProperty("mail.smtp.socketFactory.port", "465");
		  props.setProperty("mail.smtp.socketFactory.class",
		    "javax.net.ssl.SSLSocketFactory");
		  props.setProperty("mail.smtp.port", "465");
		
	}
	public static void Yahooserver(){
		
		 props.setProperty("mail.smtp.host", "smtp.mail.yahoo.com");
		 props.setProperty("mail.transport.protocol", "smtp");
		 props.setProperty("mail.smtp.starttls.enable","true");
	     props.setProperty("mail.smtp.auth", "true");
	     props.setProperty("mail.smtp.socketFactory.port", "465");
		 props.setProperty("mail.smtp.socketFactory.class",
		    "javax.net.ssl.SSLSocketFactory");
		 props.setProperty("mail.smtp.port", "465");
	}
	public static void Mailserver(){
		 props.setProperty("mail.smtp.host", "smtp.mail.com");
		 props.setProperty("mail.transport.protocol", "smtp");
		 props.setProperty("mail.smtp.starttls.enable","true");
		 props.setProperty("mail.smtp.auth", "true");
		 props.setProperty("mail.smtp.socketFactory.port", "465");
		 props.setProperty("mail.smtp.socketFactory.class",
		    "javax.net.ssl.SSLSocketFactory");
		 props.setProperty("mail.smtp.port", "465");
	}
	public static void Hotmailserver(){
	
		 props.setProperty("mail.transport.protocol", "smtp");
		 props.setProperty("mail.smtp.host", "smtp.live.com");
		 props.setProperty("mail.smtp.starttls.enable","true");
		 props.setProperty("mail.smtp.socketFactory.port", "587");
		 props.setProperty("mail.smtp.auth", "true");
		 props.setProperty("mail.smtp.port", "587");
	}
}

