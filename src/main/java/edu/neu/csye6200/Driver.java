package edu.neu.csye6200;

import edu.neu.csye6200.utils.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Driver extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                Driver frame = new Driver();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}

	public Driver() {
		setMainFrameProperties();
		createContentPane();
		addWelcomeLabel();
		addLoginTypeButton();
		addExitButton();
		initializeFlightData();
	}

	private void setMainFrameProperties() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 451);
		setTitle("Welcome");
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
		welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		welcomeLabel.setBounds(81, 11, 414, 28);
		contentPane.add(welcomeLabel);
	}

	private void addLoginTypeButton() {
		JButton loginTypeButton = new JButton("Click here to select your login type");
		loginTypeButton.addActionListener(e -> {
			dispose();
            UserModeSelection userModeSelection = new UserModeSelection();
            userModeSelection.setVisible(true);
        });
		loginTypeButton.setBounds(158, 129, 249, 23);
		contentPane.add(loginTypeButton);
	}

	private void addExitButton() {
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(e -> System.exit(0));
		exitButton.setBounds(552, 277, 89, 23);
		contentPane.add(exitButton);
	}

	private void initializeFlightData() {

		for (String str: CSVReader.readCSV(StringRes.DOMESTIC)) {
			LocalFlightSchedule.domesticFlightList.add(new DomesticFlight(str));
		}

		for (String str: CSVReader.readCSV(StringRes.INTERNATIONAL)) {
			InternationalFlightSchedule.flightList2.add(new InternationalFlight(str));
		}

		for (String str: CSVReader.readCSV(StringRes.PASSENGERS)) {
			SignUP.PassengerList.add(new Passengers(str));
		}
	}
}

