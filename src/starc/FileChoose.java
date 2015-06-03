package starc;

import java.io.File;
import javax.swing.JFileChooser;

/*
 * The function takefile is responsible for setting the attachment file path.
 * The function TakefileInline is responsible for setting the inline attachment.
 * 
 */

public class FileChoose {

	public static boolean Takefile() {
		JFileChooser fileopen = new JFileChooser();
		int ret = fileopen.showDialog(null, "Open file");

		if (ret == JFileChooser.APPROVE_OPTION) {
			File file = fileopen.getSelectedFile();
			Testdatageneration.path = file.getAbsolutePath();
			Testdatageneration.Logtextarea.append("Body attachment path " + Testdatageneration.path + "\n");
			return true;
		}
		return false;
	}

	public static boolean TakefileInline() {
		JFileChooser fileopen = new JFileChooser();
		int ret = fileopen.showDialog(null, "Open file");

		if (ret == JFileChooser.APPROVE_OPTION) {
			File file = fileopen.getSelectedFile();
			Testdatageneration.inlinepath = file.getAbsolutePath();
			Testdatageneration.Logtextarea.append("Inline attachment path " + Testdatageneration.inlinepath
					+ "\n");
			return true;
		}
		return false;
	}

}
