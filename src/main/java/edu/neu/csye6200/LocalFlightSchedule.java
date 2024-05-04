package edu.neu.csye6200;

import edu.neu.csye6200.utils.DomesticFlight;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class LocalFlightSchedule extends JFrame {

	private JPanel contentPane;
	static JTable table;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnEdit;
	private JLabel lblLocalFlightSchedule;
	private JButton btnBack;
	static List<DomesticFlight> domesticFlightList = new ArrayList<>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalFlightSchedule frame = new LocalFlightSchedule();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LocalFlightSchedule() {
		setMainFrameProperties();
		createContentPane();
		initializeTable();
		addButtons();
		addLabels();
	}

	private void setMainFrameProperties() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 423);
	}

	private void createContentPane() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private void initializeTable() {
		String[] columns = {"DomesticFlight ID", "Time", "Date", "Departure Destination",
				"Land Destination", "Economy Seats", "Business Seats", "Time Duration"};

		DefaultTableModel obj = new DefaultTableModel(columns, 0);

		for (DomesticFlight domesticFlight : LocalFlightSchedule.domesticFlightList) {
			Object[] update = {domesticFlight.getFlightID(), domesticFlight.getDepartTime(), domesticFlight.getLandTime(),
					domesticFlight.getDepartDestination(), domesticFlight.getLandDestination(),
					domesticFlight.getEconomySeats(), domesticFlight.getBusinessSeats(), domesticFlight.getDistance()};

			obj.addRow(update);
		}


		table = new JTable(obj);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 39, 764, 200);
		contentPane.add(scrollPane);
	}

	private void addButtons() {
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLocalFlight obj = new AddLocalFlight();
				obj.setVisible(true);
				dispose();
			}
		});
		btnAdd.setBounds(161, 250, 89, 23);
		contentPane.add(btnAdd);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(e -> {
			handleDeleteAction();
		});
		btnDelete.setBounds(260, 250, 89, 23);
		contentPane.add(btnDelete);

		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleEditAction();
			}
		});
		btnEdit.setBounds(359, 250, 89, 23);
		contentPane.add(btnEdit);

		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightMenu obj = new FlightMenu();
				obj.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(458, 250, 89, 23);
		contentPane.add(btnBack);
	}


	private void addLabels() {
		lblLocalFlightSchedule = new JLabel("Local DomesticFlight Schedule");
		lblLocalFlightSchedule.setFont(new Font("Calibri", Font.BOLD, 15));
		lblLocalFlightSchedule.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocalFlightSchedule.setBounds(10, 11, 680, 17);
		contentPane.add(lblLocalFlightSchedule);
	}

	private void handleDeleteAction() {
		if (table.getSelectedRowCount() == 1) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.removeRow(table.getSelectedRow());
			domesticFlightList.remove(table.getSelectedRow() + 1);
			JOptionPane.showMessageDialog(null, "Selected flight has been deleted.");
		} else if (table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Please select a row first.");
		} else {
			JOptionPane.showMessageDialog(null, "Please select one row at a time.");
		}
	}

	private void handleEditAction() {
		if (table.getSelectedRowCount() == 1) {
			EditLocalFlight obj = new EditLocalFlight();
			obj.setVisible(true);
			dispose();
		} else if (table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Please select a row first");
		} else {
			JOptionPane.showMessageDialog(null, "Please select one row at a time");
		}
	}
}
