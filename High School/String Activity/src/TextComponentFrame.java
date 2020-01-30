import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TextComponentFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 16 * 66;
	public static final int DEFAULT_HEIGHT = 9 * 66;

	public TextComponentFrame() {
		setTitle("Subscription Form");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocationRelativeTo(null);

		final JTextField personName = new JTextField();
		final JTextField emailField = new JTextField();
		final JTextField zipCode = new JTextField();
		final JTextField birthDate = new JTextField();
		final JTextField phone = new JTextField();
		final JPasswordField passwordField = new JPasswordField();

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(6, 6)); // dimensons of layout
		northPanel.add(new JLabel("Name :  ", SwingConstants.RIGHT));
		northPanel.add(personName);

		northPanel.add(new JLabel("Password :  ", SwingConstants.RIGHT));
		northPanel.add(passwordField);

		northPanel.add(new JLabel("Email : ", SwingConstants.RIGHT));
		northPanel.add(emailField);
		northPanel.add(new JLabel("Zip Code : ", SwingConstants.RIGHT));
		northPanel.add(zipCode);
		northPanel.add(new JLabel("Year of Birth: ", SwingConstants.RIGHT));
		northPanel.add(birthDate);
		northPanel.add(new JLabel("Phone Number: ", SwingConstants.RIGHT));
		northPanel.add(phone);
		phone.setText("XXX-XXX-XXXX");

		add(northPanel, BorderLayout.NORTH);

		final JTextArea textArea = new JTextArea(8, 40);
		JScrollPane scrollPane = new JScrollPane(textArea);

		add(scrollPane, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();

		JButton insertButton = new JButton("Insert");
		southPanel.add(insertButton);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				char[] cPssword = passwordField.getPassword();

				// ****************************CHANGE CODE ABOVE AT OWN
				// RISK*******************************
				// ********************* Here is where the action is
				// performed!!!!************************
				String candidateName = personName.getText();
				String candidateEmail = emailField.getText();
				String candidateZipCode = zipCode.getText();
				String candidateBirthdate = birthDate.getText();
				String candidatePhone = phone.getText();
				String candidatePassword = new String(cPssword);
				// Below this comment is where you will call your methods once
				// they have been created.

				String msg = "";
				if (!isValidName(candidateName))
					msg += "Invalid name! (must be at least 2 letters and contain no numbers)\n";
				if (!isValidEmail(candidateEmail))
					msg += "Invalid email! (must contain an \"@\" and a domain)\n";
				if (!isValidZIPCode(candidateZipCode))
					msg += "Invalid ZIP code! (must be only 5 numbers between 0 and 9)\n";
				if (!isValidBirthYear(candidateBirthdate))
					msg += "Invalid birth year! (be reasonable)\n";
				if (!isValidPhoneNumber(candidatePhone))
					msg += "Invalid phone number!\n";
				if (!isValidPassword(candidatePassword))
					msg += "Invalid password!\n";
				
				if (msg.equalsIgnoreCase(""))
					msg = "Successfully added your information!";
				
				// This method below allows text to appear in the GUI.
				textArea.setText(msg);

				// ****************************CHANGE CODE BELOW AT OWN
				// RISK***********************************

			}
		});
		add(southPanel, BorderLayout.SOUTH);
	}
	// Create all 8 methods below this comment

	public static boolean isAllAlpha(String s) {
		return !s.matches(".*[0-9].*") && s.matches(".*[a-zA-Z].*");
	}
	
	public static boolean isNumeric(String s) {
		return s.matches(".*[0-9].*") && !s.matches(".*[a-zA-Z].*");
	}
	
	public static boolean isValidName(String s) {
		return s.length() >= 2 && isAllAlpha(s);
	}
	
	public static boolean isValidPassword(String s) {
		return s.length() >= 4 && s.matches(".*[0-9].*") && !s.toLowerCase().equals(s) && !s.toUpperCase().equals(s);
	}
	
	public static boolean isValidEmail(String s) {
		if (!s.contains("@"))
			return false;
		return s.substring(s.indexOf("@")).contains(".");
	}
	
	public static boolean isValidZIPCode(String s) {
		return s.length() == 5 && isNumeric(s);
	}
	
	public static boolean isValidBirthYear(String s) {
		return Integer.parseInt(s) >= 1930;
	}
	
	public static boolean isValidPhoneNumber(String s) {
		if (!s.contains("-") || s.length() < 12 || !isNumeric(s))
			return false;
		return s.substring(3, 4).equalsIgnoreCase("-") && s.substring(7, 8).equalsIgnoreCase("-");
	}
	
}