package starc;

import java.util.Random;

public class Counter extends Testdatageneration {
	
	/*
	 * Function to generate random string based on input for email's subject
	 * and for email's body
	 * 
	 */

	public static String generateSessionKey(int length) {

		String alphabet = new String(
				"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
		int n = alphabet.length();

		String result = new String();
		Random r = new Random();

		for (int i = 0; i < length; i++)

			result = result + alphabet.charAt(r.nextInt(n));
		Testdatageneration.Logtextarea.append("Printing generated key  " + result + "\n");
		return result;
	}
}
