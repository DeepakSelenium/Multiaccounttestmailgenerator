package starc;

import java.awt.EventQueue;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;

import java.awt.Window.Type;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JRadioButton;

import java.awt.SystemColor;

import javax.swing.SwingConstants;

public class Testdatageneration {

	/*
	 * Testdatageneration is main swing class
	 * Responsible for drawing the GUI of this utility
	 */

	// Defined static variable to use them across the project
	protected static JFrame frmKarna;
	private JTextField Totextfield;
	private JTextField Messagebodylength;
	public static JTextField Mails;
	public static String subject;
	public static String subjectisavailable;
	public static String Tomailid;
	public static int Mailsubjectlenght;
	public static int MessageBody;
	public static int Numberofemails;
	public static JTextArea Logtextarea;
	public static String path;
	public static String inlinepath;
	public static BodyPart messageBodyPart;
	public static Multipart multipart;
	public static MimeMessage message;
	public static Session session;
	public static String result;
	public static MimeBodyPart attachPart;
	public static JTextField EditsubjecttextField;
	public static JTextField Subjectlengthtextfield;
	public static String MailSubjecteditable;
	public static JRadioButton rdbtnEditSubject;
	public static JRadioButton rdbtnEnterSubjectLength;
	public static boolean isEditable;
	public static boolean isLengthavailable;
	public static String Sublength;
	public static boolean issubjectlengthnotavailable;
	public static boolean isbodycontentnotavailable;
	public static boolean isbodycontentavailable;
	public static String username="synzimbra@gmail.com";;
	public static String password="synerzip123";
	public static boolean Gmail;
    public static boolean Mobdev1;
    public static boolean Yahoo;
    public static boolean Mail;
    public static boolean Hotmail;
    public static Properties props;
    public static boolean Default=true;
            
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			//@SuppressWarnings("static-access")
			public void run() {
				try {
					Testdatageneration window = new Testdatageneration();
					window.frmKarna.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Testdatageneration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// Defined the main frame with image in classpath
		frmKarna = new JFrame();
		frmKarna.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Testdatageneration.class
						.getResource("/Images/logo_synerzip.gif")));
		frmKarna.setResizable(false);
		frmKarna.setType(Type.POPUP);
		frmKarna.getContentPane().setFont(new Font("Verdana", Font.BOLD, 11));
		frmKarna.getContentPane().setBackground(SystemColor.scrollbar);
		frmKarna.setBounds(new Rectangle(50, 0, 1000, 600));
		frmKarna.getContentPane().setLayout(null);
		frmKarna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Defined the "TO" field label
		JLabel lblMandatorytoField = new JLabel("Mandatory \"To\" field");
		lblMandatorytoField.setBackground(SystemColor.desktop);
		lblMandatorytoField.setForeground(Color.BLACK);
		lblMandatorytoField.setFont(new Font("Verdana", Font.BOLD, 11));
		lblMandatorytoField.setBounds(22, 72, 146, 40);
		frmKarna.getContentPane().add(lblMandatorytoField);

		// Defined the tool tip
		Totextfield = new JTextField();
		Totextfield.setFont(new Font("Verdana", Font.PLAIN, 12));
		Totextfield.setBackground(SystemColor.text);
		Totextfield
				.setToolTipText("Please enter your recipient in \"TO\" field. This field is mandatory and can not be left blank");
		Totextfield.setBounds(177, 78, 186, 29);
		frmKarna.getContentPane().add(Totextfield);
		Totextfield.setColumns(10);

		// Defined subject length text field and tool tip
		Subjectlengthtextfield = new JTextField();
		Subjectlengthtextfield.setFont(new Font("Verdana", Font.PLAIN, 12));
		Subjectlengthtextfield.setBackground(SystemColor.text);
		Subjectlengthtextfield
				.setToolTipText("User can enter mail subject length in to this field.Mail subject will appear after a random number, which is there to identify the mails from other mails. By default it's length has been set to 5");
		Subjectlengthtextfield.setColumns(10);
		Subjectlengthtextfield.setBounds(305, 202, 58, 29);
		frmKarna.getContentPane().add(Subjectlengthtextfield);

		JLabel lblEnterMessageBody = new JLabel("Enter message body length");
		lblEnterMessageBody.setForeground(Color.BLACK);
		lblEnterMessageBody.setFont(new Font("Verdana", Font.BOLD, 11));
		lblEnterMessageBody.setBounds(22, 264, 178, 40);
		frmKarna.getContentPane().add(lblEnterMessageBody);

		// Defined the tool tip
		Messagebodylength = new JTextField();
		Messagebodylength.setFont(new Font("Verdana", Font.PLAIN, 12));
		Messagebodylength.setBackground(SystemColor.text);
		Messagebodylength
				.setToolTipText("User can enter message body length in to this field.This field will appear after a random number which is there to identify the mails from othe mail.By default it's value has been set to 50");
		Messagebodylength.setColumns(10);
		Messagebodylength.setBounds(306, 270, 58, 29);
		frmKarna.getContentPane().add(Messagebodylength);

		// Defined the label
		JLabel lblInterestedInSending = new JLabel("Attachment in body");
		lblInterestedInSending.setForeground(Color.BLACK);
		lblInterestedInSending.setFont(new Font("Verdana", Font.BOLD, 11));
		lblInterestedInSending.setBounds(22, 315, 132, 40);
		frmKarna.getContentPane().add(lblInterestedInSending);

		// Defined the text area
		Logtextarea = new JTextArea("Logger :-" + "\n");
		Logtextarea.setFont(new Font("Verdana", Font.PLAIN, 12));
		Logtextarea
				.setToolTipText("You will see the data generated in to mails");
		Logtextarea.setBackground(SystemColor.text);
		Logtextarea.setBounds(411, 24, 262, 381);
		Logtextarea.setEditable(true);
		Logtextarea.setLineWrap(false);
		Logtextarea.setWrapStyleWord(true);
		frmKarna.getContentPane().add(Logtextarea);

		// Defined the scroll pane
		JScrollPane sp = new JScrollPane(Logtextarea);
		sp.setBounds(400, 20, 350, 400);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		frmKarna.getContentPane().add(sp);

		// Defined the label
		JLabel lblNum = new JLabel("Number of mails to send");
		lblNum.setBackground(Color.BLACK);
		lblNum.setForeground(Color.BLACK);
		lblNum.setFont(new Font("Verdana", Font.BOLD, 11));
		lblNum.setBounds(22, 14, 166, 40);
		frmKarna.getContentPane().add(lblNum);

		// Defined the tool tip
		Mails = new JTextField();
		Mails.setEnabled(true);
		Mails.setFont(new Font("Verdana", Font.PLAIN, 12));
		Mails.setToolTipText("Number of mails to send.The number which you enter in this field ,your mails will be fired at same number of times.By default it is set to one.");
		Mails.setColumns(10);
		Mails.setBackground(SystemColor.text);
		Mails.setBounds(306, 20, 58, 29);
		frmKarna.getContentPane().add(Mails);
		frmKarna.setFont(new Font("Verdana", Font.BOLD, 12));
		frmKarna.setBackground(SystemColor.textHighlight);
		frmKarna.setTitle("ZIMBRA MULTI ACCOUNT UTIL");

		// Defined the "edit subject" radio button
		JRadioButton rdbtnEditSubject = new JRadioButton("Edit subject");
		rdbtnEditSubject.setSelected(true);
		rdbtnEditSubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtnEditSubject.isSelected()) {
					isEditable = true;
					EditsubjecttextField.setEditable(true);
					Subjectlengthtextfield.setText("");
					Subjectlengthtextfield.setEditable(false);
				}
			}
		});
		rdbtnEditSubject.setForeground(Color.BLACK);
		rdbtnEditSubject.setBackground(Color.LIGHT_GRAY);
		rdbtnEditSubject.setFont(new Font("Verdana", Font.BOLD, 11));
		rdbtnEditSubject.setBounds(22, 146, 109, 23);
		frmKarna.getContentPane().add(rdbtnEditSubject);

		// Defined the "Subject length" radio button
		JRadioButton rdbtnEnterSubjectLength = new JRadioButton(
				"Enter subject length");
		rdbtnEnterSubjectLength.setSelected(false);
		rdbtnEnterSubjectLength.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtnEnterSubjectLength.isSelected()) {
					Subjectlengthtextfield.setEditable(true);
					EditsubjecttextField.setText("");
					EditsubjecttextField.setEditable(false);

				}

			}
		});
		rdbtnEnterSubjectLength.setForeground(Color.BLACK);
		rdbtnEnterSubjectLength.setBackground(Color.LIGHT_GRAY);
		rdbtnEnterSubjectLength.setFont(new Font("Verdana", Font.BOLD, 11));
		rdbtnEnterSubjectLength.setBounds(22, 205, 178, 23);
		frmKarna.getContentPane().add(rdbtnEnterSubjectLength);

		// Defined the send button ,responsible for sending the all mails
		JButton Fire = new JButton("Send");
		Fire.setToolTipText("Your mail will be fired.");
		Fire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Tomailid = Totextfield.getText().trim().toString();
				Logtextarea.append("To field email id :-" + Tomailid + "\n");

				subject = EditsubjecttextField.getText().trim().toString();
				Sublength = Subjectlengthtextfield.getText().trim().toString();

				if (rdbtnEditSubject.isSelected()) {
					if (subject.isEmpty()) {
						subjectisavailable = "";
						Logtextarea.append("Default mail subject has been set "
								+ "\n");
					} else if (subject != null && !subject.equals("")) {
						isEditable = true;
						subjectisavailable = subject;
						Logtextarea.append("Mail subject " + subject + "\n");
					}
				} else if (rdbtnEnterSubjectLength.isSelected()) {
					if (Sublength.isEmpty()) {
						issubjectlengthnotavailable=true;
						Mailsubjectlenght = 5;
						Logtextarea
								.append("Default value has been set for mail subject length"
										+ "\n");
					} else if (Sublength != null && !Sublength.equals("")) {
						isLengthavailable = true;
						Mailsubjectlenght = Integer.parseInt(Sublength);
						Logtextarea.append("Mail subject length "
								+ Mailsubjectlenght + "\n");
					}
				}

				String Bodylength = Messagebodylength.getText().trim()
						.toString();
				if (Bodylength.isEmpty()) {
					MessageBody = 0;
					isbodycontentnotavailable=true;
					Logtextarea
							.append("Default value has been set for message body length "
									+ "\n");
				} else {
					isbodycontentavailable=true;
					MessageBody = Integer.parseInt(Bodylength);
					Logtextarea.append("Body length " + MessageBody + "\n");
				}

				String Loops = Mails.getText().trim().toString();
				if (Loops.isEmpty()) {
					Numberofemails = 1;
					Logtextarea
							.append("Default value has been set for mail loop "
									+ "\n");
				} else {
					Numberofemails = Integer.parseInt(Loops);
					Logtextarea.append("Number of mails to send in loop "
							+ Numberofemails + "\n");
				}

				int i = 1;

				while (i <= Numberofemails) {
					Logtextarea.append("Mail send attempt " + i + "\n");
					try {
						EmailServer.ActualSend();
						Thread.sleep(3000l);
					} catch (IOException | InterruptedException e) {
						Logtextarea.append("Mail could not be send attempt "
								+ i + "\n");
						e.printStackTrace();
					}
					i++;
				}
				try {
					Randomnumbergenerator.Cleanupvariable();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				JOptionPane.showMessageDialog(frmKarna,
						"Mails sent successfully", "Task completed",
						JOptionPane.INFORMATION_MESSAGE);
				Logtextarea.append("Completed" + "\n");
		}
		});
		Fire.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		Fire.setBackground(Color.WHITE);
		Fire.setBounds(419, 525, 88, 23);
		frmKarna.getContentPane().add(Fire);

		// Defined the browse button to send attachment
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FileChoose.Takefile();
			}
		});
		btnBrowse.setBackground(SystemColor.text);
		btnBrowse.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnBrowse.setBounds(282, 331, 82, 23);
		frmKarna.getContentPane().add(btnBrowse);

		// Defined the button to send inline attachment
		JButton btnInlinebrowse = new JButton("Inline Browse");
		btnInlinebrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileChoose.TakefileInline();
			}
		});
		btnInlinebrowse.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnInlinebrowse.setBackground(SystemColor.text);
		btnInlinebrowse.setBounds(246, 375, 117, 23);
		frmKarna.getContentPane().add(btnInlinebrowse);

		// Defined the label inline attachment
		JLabel lblInlineAttachment = new JLabel("Inline attachment");
		lblInlineAttachment.setForeground(Color.BLACK);
		lblInlineAttachment.setFont(new Font("Verdana", Font.BOLD, 11));
		lblInlineAttachment.setBounds(22, 366, 125, 40);
		frmKarna.getContentPane().add(lblInlineAttachment);

		// Defined the text field to enter subject
		EditsubjecttextField = new JTextField();
		//EditsubjecttextField.setEditable(false);
		EditsubjecttextField.setBackground(SystemColor.text);
		EditsubjecttextField.setFont(new Font("Verdana", Font.PLAIN, 11));
		EditsubjecttextField.setBounds(177, 146, 186, 25);
		frmKarna.getContentPane().add(EditsubjecttextField);
		EditsubjecttextField.setColumns(10);

		// Created the group of button to enable only one button at a time
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnEditSubject);
		group.add(rdbtnEnterSubjectLength);
		
		JRadioButton rdbtnGmailServer = new JRadioButton("Gmail Server");
		rdbtnGmailServer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Logtextarea.append("Gmail server to be connected"+ "\n");
				Gmail=true;
				Mobdev1=false;
				Yahoo=false;
				Mail=false;
				Hotmail=false;
				Default=false;
				username = "synzimbra@gmail.com";
				password = "synerzip123";
			}
		});
		rdbtnGmailServer.setSelected(true);
		rdbtnGmailServer.setForeground(Color.BLACK);
		rdbtnGmailServer.setFont(new Font("Verdana", Font.BOLD, 11));
		rdbtnGmailServer.setBackground(Color.LIGHT_GRAY);
		rdbtnGmailServer.setBounds(22, 462, 117, 23);
		frmKarna.getContentPane().add(rdbtnGmailServer);
		
		JRadioButton rdbtnZimbraServer = new JRadioButton("Mobdev1 Server");
		rdbtnZimbraServer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Logtextarea.append("Mobdev1 server to be connected"+ "\n");
				Gmail=false;
				Mobdev1=true;
				Yahoo=false;
				Mail=false;
				Hotmail=false;
				Default=false;
				username = "sync@mobdev1.zimbra.com";
				password = "test123";
			}
		});
		rdbtnZimbraServer.setSelected(false);
		rdbtnZimbraServer.setForeground(Color.BLACK);
		rdbtnZimbraServer.setFont(new Font("Verdana", Font.BOLD, 11));
		rdbtnZimbraServer.setBackground(Color.LIGHT_GRAY);
		rdbtnZimbraServer.setBounds(200, 462, 132, 23);
		frmKarna.getContentPane().add(rdbtnZimbraServer);
		
		JRadioButton rdbtnYahooServer = new JRadioButton("Yahoo Server");
		rdbtnYahooServer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Logtextarea.append("Yahoo server to be connected"+ "\n");
				Gmail=false;
				Mobdev1=false;
				Yahoo=true;
				Mail=false;
				Hotmail=false;
				Default=false;
				username = "usseals_3@yahoo.co.in";
				password = "anaksunam";
				
			}
		});
		rdbtnYahooServer.setSelected(false);
		rdbtnYahooServer.setForeground(Color.BLACK);
		rdbtnYahooServer.setFont(new Font("Verdana", Font.BOLD, 11));
		rdbtnYahooServer.setBackground(Color.LIGHT_GRAY);
		rdbtnYahooServer.setBounds(405, 462, 117, 23);
		frmKarna.getContentPane().add(rdbtnYahooServer);
		
		JRadioButton rdbtnRediffServer = new JRadioButton("Mail Server");
		rdbtnRediffServer.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnRediffServer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Logtextarea.append("Mail server to be connected"+ "\n");
				Gmail=false;
				Mobdev1=false;
				Yahoo=false;
				Mail=true;
				Hotmail=false;
				Default=false;
				username = "kumar.deepaktiwari@mail.com";
				password = "Deepaktiwari4";
		}
		});
		rdbtnRediffServer.setSelected(false);
		rdbtnRediffServer.setForeground(Color.BLACK);
		rdbtnRediffServer.setFont(new Font("Verdana", Font.BOLD, 11));
		rdbtnRediffServer.setBackground(Color.LIGHT_GRAY);
		rdbtnRediffServer.setBounds(591, 463, 109, 23);
		frmKarna.getContentPane().add(rdbtnRediffServer);
		
		JRadioButton rdbtnHotmailServer = new JRadioButton("Hotmail server");
		rdbtnHotmailServer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Logtextarea.append("Hotmail server to be connected"+ "\n");
				Gmail=false;
				Mobdev1=false;
				Yahoo=false;
				Mail=false;
				Hotmail=true;
				Default=false;
				username = "kumar.deepaktiwari@hotmail.com";
				password = "Deepaktiwari4";
			}
		});
		rdbtnHotmailServer.setSelected(false);
		rdbtnHotmailServer.setForeground(Color.BLACK);
		rdbtnHotmailServer.setFont(new Font("Verdana", Font.BOLD, 11));
		rdbtnHotmailServer.setBackground(Color.LIGHT_GRAY);
		rdbtnHotmailServer.setBounds(771, 463, 125, 23);
		frmKarna.getContentPane().add(rdbtnHotmailServer);
		
		// Created the group of button to enable only one button at a time
		ButtonGroup grouptwo = new ButtonGroup();
		grouptwo.add(rdbtnGmailServer);
		grouptwo.add(rdbtnZimbraServer);
		grouptwo.add(rdbtnYahooServer);
		grouptwo.add(rdbtnRediffServer);
		grouptwo.add(rdbtnHotmailServer);
		
	}
}
