package edu.neu.csye6200;


import edu.neu.csye6200.utils.Admin;
import edu.neu.csye6200.utils.StringRes;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminLogin extends JFrame {

    //Content pane for organizing components
    private JPanel contentPane;

    //Text field for entering the username
    private JTextField usernameField;
    //Password field for entering the password
    private JPasswordField passwordField;
    private static ArrayList<Admin> adminList = new ArrayList<>();  //List to store admin objects

    public static void main(String[] args) {
        // Use EventQueue to ensure GUI-related tasks run on the event-dispatching thread
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminLogin frame = new AdminLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Constructor for AdminLogin class. Initializes the GUI components and sets up the
     * initial admin information for testing.
     */
    public AdminLogin() {

        // Setting up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 558, 389);
        setTitle("Admin Login");
        // Creating the content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Adding GUI components
        JLabel titleLabel = new JLabel(StringRes.TITLE.getValue());
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Calibri", Font.ITALIC, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(10, 11, 457, 34);
        contentPane.add(titleLabel);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        usernameLabel.setBounds(118, 81, 91, 17);
        contentPane.add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setBounds(118, 136, 91, 17);
        contentPane.add(passwordLabel);

        usernameField = new JTextField();
        usernameField.setBounds(237, 78, 86, 20);
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(237, 133, 86, 20);
        contentPane.add(passwordField);

        // Initializing admin information for testing
        Admin admin = new Admin("admin", "admin");
        adminList.add(admin);

        // Adding action listeners to buttons
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> handleLogin());
        loginButton.setBounds(237, 176, 89, 23);
        contentPane.add(loginButton);

        JButton backButton = new JButton(StringRes.BACK.getValue());
        backButton.addActionListener(e -> {
            dispose();
            new UserModeSelection().setVisible(true);
        });
        backButton.setBounds(367, 176, 89, 23);
        contentPane.add(backButton);
    }

    /**
     * Handles the login process by comparing entered username and password
     * with the admin information stored in the adminList.
     */
    private void handleLogin() {
        // Getting entered username and password
        String enteredUsername = usernameField.getText();
        String enteredPassword = new String(passwordField.getPassword());

        // Looping through adminList for authentication
        for (Admin admin : adminList) {
            if (enteredUsername.equals(admin.getUsername()) && enteredPassword.equals(admin.getPassword())) {
                FlightMenu flightMenu = new FlightMenu();
                flightMenu.setVisible(true);
                dispose();
                return;
            } else if (enteredUsername.equals(admin.getUsername())) {
                JOptionPane.showMessageDialog(null, "Incorrect Password. Please Enter Again.");
                return;
            } else if (enteredPassword.equals(admin.getPassword())) {
                JOptionPane.showMessageDialog(null, "Incorrect Username. Please Enter Again.");
                return;
            }
        }

        // Displaying appropriate messages based on authentication result
        JOptionPane.showMessageDialog(null, "You are not a registered Admin.");
    }
}
