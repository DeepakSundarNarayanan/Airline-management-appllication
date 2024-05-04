package edu.neu.csye6200;

import edu.neu.csye6200.utils.CSVReader;
import edu.neu.csye6200.utils.Passengers;
import edu.neu.csye6200.utils.StringRes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class SignUP extends JFrame {

    private JPanel contentPane;
    private JTextField fullName;
    private JTextField phoneNumber;
    private JPasswordField password;
    private JPasswordField confirmPassword;
    static List<Passengers> PassengerList = new ArrayList<>();
    static JTextField username;
    private JTextField passport;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SignUP frame = new SignUP();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SignUP() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 636, 436);
        setTitle("SignUp Here");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel(StringRes.TITLE.getValue());
        lblNewLabel.setFont(new Font("Calibri", Font.ITALIC, 18));
        lblNewLabel.setBounds(152, 11, 389, 29);
        contentPane.add(lblNewLabel);

        // Labels for user details
        String[] labels = {"Full Name", "Phone Number", "Passport","Username", "Password", "Confirm Password"};
        int yPos = 65;
        for (String label : labels) {
            JLabel lbl = new JLabel(label);
            lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lbl.setBounds(37, yPos, 150, 20);
            contentPane.add(lbl);
            yPos += 40;
        }

        fullName = new JTextField();
        fullName.setBounds(214, 65, 150, 20);
        contentPane.add(fullName);
        fullName.setColumns(10);

        phoneNumber = new JTextField();
        phoneNumber.setBounds(214, 105, 150, 20);
        contentPane.add(phoneNumber);

        passport = new JTextField();
        passport.setBounds(214, 145, 150, 20);
        contentPane.add(passport);

        username = new JTextField();
        username.setBounds(214, 185, 150, 20);
        contentPane.add(username);
        username.setColumns(10);

        password = new JPasswordField();
        password.setBounds(214, 225, 150, 20);
        contentPane.add(password);

        confirmPassword = new JPasswordField();
        confirmPassword.setBounds(214, 265, 150, 20);
        contentPane.add(confirmPassword);

        JButton btnNewButton = new JButton("Sign Up");
        btnNewButton.addActionListener(e -> signUpButtonAction());
        btnNewButton.setBounds(387, 348, 89, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton(StringRes.BACK.getValue());
        btnNewButton_1.addActionListener(e -> backToLogin());
        btnNewButton_1.setBounds(503, 348, 89, 23);
        contentPane.add(btnNewButton_1);
    }

    private void signUpButtonAction() {
        int chk = 0;
        for (int i = 0; i < password.getText().length(); i++) {
            char check = password.getText().charAt(i);
            if (Character.isUpperCase(check)) {
                chk += 1;
                break;
            }
        }

        if (isAnyFieldEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields.");
        } else if (isUserAlreadyRegistered()) {
            JOptionPane.showMessageDialog(null, "This username is already registered. Please choose another.");
        } else if (!password.getText().equals(confirmPassword.getText())) {
            JOptionPane.showMessageDialog(null, "Passwords do not match.");
        } else if (password.getText().length() < 8) {
            JOptionPane.showMessageDialog(null, "Password cannot be less than 8 characters.");
        } else if (!password.getText().matches(".*[@!%#^&*_].*")) {
            JOptionPane.showMessageDialog(null, "Password must have a special character");
        } else if (phoneNumber.getText().length() != 10 || !phoneNumber.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Enter a valid phone number of 10 digits.");
        } else if (chk < 1) {
            JOptionPane.showMessageDialog(null, "Password must have at least one uppercase letter.");
        } else {
            Passengers obj = new Passengers(fullName.getText(), phoneNumber.getText(), username.getText(), password.getText(), passport.getText());
            PassengerList.add(obj);
            CSVReader.addToCSV(StringRes.PASSENGERS, obj.toString());

//            Login obj1 = new Login();
//            obj1.setVisible(true);
//            dispose();
        }
    }

    private boolean isAnyFieldEmpty() {
        return username.getText().isEmpty() ;
    }

    private boolean isUserAlreadyRegistered() {
        for (Passengers x : PassengerList) {
            if (x.getUsername().equals(username.getText()) || x.getPhoneNumber().equals(phoneNumber.getText())) {
                return true;
            }
        }
        return false;
    }

    private void backToLogin() {
        Login obj = new Login();
        obj.setVisible(true);
        dispose();
    }
}
