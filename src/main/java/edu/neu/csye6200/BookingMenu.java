package edu.neu.csye6200;

import edu.neu.csye6200.utils.StringRes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BookingMenu extends JFrame {

	/**
	 * Main method to launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				BookingMenu frame = new BookingMenu();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Constructor to create frame.
	 */
	public BookingMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 406);
		setTitle("Booking Menu");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel welcomeLabel = new JLabel(StringRes.TITLE.getValue());
		welcomeLabel.setFont(new Font("Calibri", Font.ITALIC, 18));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(83, 11, 414, 31);
		contentPane.add(welcomeLabel);

		JButton localFlightsButton = new JButton("Local Flights");
		localFlightsButton.addActionListener(e -> {
			dispose();
			new BookLocalFlight().setVisible(true);
		});
		localFlightsButton.setBounds(202, 110, 150, 23);
		contentPane.add(localFlightsButton);

		JButton internationalFlightsButton = new JButton("International Flights");
		internationalFlightsButton.addActionListener(e -> {
			dispose();
			new BookInternationalFlight().setVisible(true);
		});
		internationalFlightsButton.setBounds(202, 159, 150, 23);
		contentPane.add(internationalFlightsButton);

		JButton backButton = new JButton(StringRes.BACK.getValue());
		backButton.addActionListener(e -> {
			dispose();
			new Login().setVisible(true);
		});
		backButton.setBounds(202, 255, 150, 23);
		contentPane.add(backButton);

		JButton resetPasswordButton = new JButton("Reset Password");
		resetPasswordButton.addActionListener(e -> {
			dispose();
			ResetPassword obj = new ResetPassword();
			obj.setVisible(true);
		});
		resetPasswordButton.setBounds(202, 204, 150, 23);
		contentPane.add(resetPasswordButton);
	}
}