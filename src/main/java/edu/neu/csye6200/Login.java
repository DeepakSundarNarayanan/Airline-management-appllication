package edu.neu.csye6200;

import edu.neu.csye6200.utils.CSVReader;
import edu.neu.csye6200.utils.StringRes;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.Font;
import java.util.Map;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                Login frame = new Login();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}

	public Login() {
		setMainFrameProperties();
		createContentPane();
		addWelcomeLabel();
		addUsernameLabel();
		addPasswordLabel();
		addUsernameTextField();
		addLoginButton();
		addSignUpButton();
		addNewLabel();
		addPasswordField();
		addBackButton();
	}

	private void setMainFrameProperties() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 401);
		setTitle("Passenger Login");
	}

	private void createContentPane() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private void addWelcomeLabel() {
		JLabel welcomeLabel = new JLabel(StringRes.TITLE.getValue());
		welcomeLabel.setFont(new Font("Calibri", Font.ITALIC, 18));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(41, 11, 414, 24);
		contentPane.add(welcomeLabel);
	}

	private void addUsernameLabel() {
		JLabel label1 = new JLabel("Username");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label1.setBounds(10, 46, 83, 17);
		contentPane.add(label1);
	}

	private void addPasswordLabel() {
		JLabel label2 = new JLabel("Password");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label2.setBounds(10, 71, 83, 17);
		contentPane.add(label2);
	}

	private void addUsernameTextField() {
		username = new JTextField();
		username.setBounds(103, 43, 121, 20);
		contentPane.add(username);
		username.setColumns(10);
	}


	private void addLoginButton() {
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(e -> authUser());
		loginbtn.setBounds(103, 99, 89, 23);
		contentPane.add(loginbtn);
	}

	private void addSignUpButton() {
		JButton signupbtn = new JButton("Sign Up");
		signupbtn.addActionListener(e -> {
			dispose();
			SignUP obj = new SignUP();
			obj.setVisible(true);
		});
		signupbtn.setBounds(103, 133, 89, 23);
		contentPane.add(signupbtn);
	}

	private void addNewLabel() {
		JLabel label3 = new JLabel("New User?");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label3.setBounds(10, 137, 83, 19);
		contentPane.add(label3);
	}

	private void addPasswordField() {
		password = new JPasswordField();
		password.setBounds(103, 71, 121, 20);
		contentPane.add(password);
	}

	private void addBackButton() {
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(e -> {
			dispose();
			new UserModeSelection().setVisible(true);
		});
		btnNewButton.setBounds(419, 137, 89, 23);
		contentPane.add(btnNewButton);
	}

	private void authUser() {
		if (username.getText().equals("") || password.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please fill all the fields");
		}

		Map<String,String> hashMap = CSVReader.loginAuth();
		String user = username.getText();
		if (hashMap.containsKey(user)) {
			if (hashMap.get(user).equals(new String(password.getPassword()))) {
				dispose();
				BookingMenu obj = new BookingMenu();
				obj.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect password. Enter Again.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "You are not a registered user.");
		}
	}
}

