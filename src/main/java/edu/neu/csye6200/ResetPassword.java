package edu.neu.csye6200;

import edu.neu.csye6200.utils.CSVReader;
import edu.neu.csye6200.utils.StringRes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ResetPassword extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private int index;
    private JPasswordField password;
    private JPasswordField confirmPassword;
    private boolean check = false;
    private JPasswordField oldPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ResetPassword frame = new ResetPassword();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ResetPassword() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 592, 382);
        setTitle("Reset your Password");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Label for the title of the frame
        JLabel lblNewLabel = new JLabel("Reset Password");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel.setBounds(10, 11, 414, 17);
        contentPane.add(lblNewLabel);

        // Text field for entering the username
        username = new JTextField();
        username.setBounds(130, 36, 86, 20);
        contentPane.add(username);
        username.setColumns(10);

        // Label for the username text field
        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setBounds(10, 39, 110, 14);
        contentPane.add(lblNewLabel_1);

        // Button to find the account associated with the entered username
        JButton btnNewButton = new JButton("Find");
        btnNewButton.addActionListener(e -> {
            SignUP.PassengerList.stream()
                    .filter(x -> x.getUsername().equals(username.getText()))
                    .findFirst()
                    .ifPresentOrElse(
                            x -> {
                                // Account found, display a message and set variables
                                JOptionPane.showMessageDialog(null, "Your account has been found. Enter your new password.");
                                check = true;
                                index = SignUP.PassengerList.indexOf(x);
                            },
                            () -> JOptionPane.showMessageDialog(null, "Your account has not been found. Please register first.")
                    );
        });
        btnNewButton.setBounds(130, 67, 89, 23);
        contentPane.add(btnNewButton);

        // Labels for new password and confirm password text fields
        JLabel lblNewLabel_2 = new JLabel("New Password");
        lblNewLabel_2.setBounds(10, 141, 110, 14);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Confirm Password");
        lblNewLabel_3.setBounds(10, 172, 110, 14);
        contentPane.add(lblNewLabel_3);

        // Button to finalize the password change
        JButton btnNewButton_1 = new JButton("Done");
        btnNewButton_1.addActionListener(e -> {
            // Count uppercase letters in the new password
            long chk = password.getText().chars().filter(Character::isUpperCase).count();

            // Check conditions for password change
            if (!check) {
                JOptionPane.showMessageDialog(null, "Please find your account first.");
            } else if (!SignUP.PassengerList.get(index).getPassword().equals(oldPassword.getText())) {
                JOptionPane.showMessageDialog(null, "Old password is incorrect.");
            } else if (!password.getText().equals(confirmPassword.getText())) {
                JOptionPane.showMessageDialog(null, "Passwords do not match.");
            } else if (password.getText().length() < 8) {
                JOptionPane.showMessageDialog(null, "Password cannot be less than 8 characters.");
            } else if (!password.getText().matches(".*[@!%#^&*_].*")) {
                JOptionPane.showMessageDialog(null, "Password must have a special character");
            } else if (chk < 1) {
                JOptionPane.showMessageDialog(null, "Password must have at least one uppercase letter.");
            } else {
                // Update password and display success message
                SignUP.PassengerList.get(index).setPassword(password.getText());
                CSVReader.editPassengerCSV(SignUP.PassengerList);
                JOptionPane.showMessageDialog(null, "Your password has been changed.");

                // Navigate to the login screen
                Login obj1 = new Login();
                obj1.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1.setBounds(130, 200, 89, 23);
        contentPane.add(btnNewButton_1);

        // Text field for entering the new password
        password = new JPasswordField();
        password.setBounds(130, 138, 86, 20);
        contentPane.add(password);

        // Text field for confirming the new password
        confirmPassword = new JPasswordField();
        confirmPassword.setBounds(130, 169, 86, 20);
        contentPane.add(confirmPassword);

        // Label for the old password text field
        JLabel lblNewLabel_4 = new JLabel("Old Password");
        lblNewLabel_4.setBounds(10, 110, 110, 14);
        contentPane.add(lblNewLabel_4);

        // Text field for entering the old password
        oldPassword = new JPasswordField();
        oldPassword.setBounds(130, 107, 86, 20);
        contentPane.add(oldPassword);

        // Button to go back
        JButton btnNewButton_2 = new JButton(StringRes.BACK.getValue());
        btnNewButton_2.addActionListener(e -> dispose());
        btnNewButton_2.setBounds(479, 298, 89, 23);
        contentPane.add(btnNewButton_2);
    }
}
