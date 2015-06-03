package starc;

import java.util.Random;

import javax.mail.MessagingException;

/*
 * This function generaterandomnumber generates the random number 
 * The function Cleanupvariable used to set the default values of variable 
 * 
 */

public class Randomnumbergenerator extends Testdatageneration {
	
	public static int generaterandomnumber(){
		
		Random r = new Random();
		int num =r.nextInt();
		return num;
	}
	public static void Cleanupvariable() throws MessagingException{
		path = null;
		inlinepath = null;
		subjectisavailable=null;
		Mailsubjectlenght=0;
		issubjectlengthnotavailable=false;
		isbodycontentavailable=false;
		isbodycontentnotavailable=false;
		issubjectlengthnotavailable=false;
		isLengthavailable=false;
		/*Gmail=false;
		Mobdev1=false;
		Yahoo=false;
		Mail=false;
		Hotmail=false;
		props.clear();
		username=null;
		password=null;*/
		
	}

}
