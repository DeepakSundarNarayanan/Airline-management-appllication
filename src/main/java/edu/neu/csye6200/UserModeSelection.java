package edu.neu.csye6200;

import edu.neu.csye6200.utils.StringRes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserModeSelection extends JFrame {

	/**
	 * Main method to launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                UserModeSelection frame = new UserModeSelection();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}

	/**
	 * Constructor to create frame.
	 */
	public UserModeSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 368);
		setTitle("Select User");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(StringRes.TITLE.getValue());
		lblNewLabel.setFont(new Font("Calibri", Font.ITALIC, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.addActionListener(e -> {
			dispose();
			AdminLogin obj=new AdminLogin();
			obj.setVisible(true);
        });
		btnNewButton.setBounds(220, 113, 106, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Passenger");
		btnNewButton_1.addActionListener(e -> {
			dispose();
			Login obj=new Login();
			obj.setVisible(true);
        });
		btnNewButton_1.setBounds(220, 178, 106, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Select your login type");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 51, 414, 29);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton(StringRes.BACK.getValue());
		btnNewButton_2.addActionListener(e -> {
			dispose();
			Driver obj = new Driver();
			obj.setVisible(true);
		});
		btnNewButton_2.setBounds(466, 234, 89, 23);
		contentPane.add(btnNewButton_2);
		
	}
}
