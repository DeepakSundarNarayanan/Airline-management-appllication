package edu.neu.csye6200;
import edu.neu.csye6200.utils.CSVReader;
import edu.neu.csye6200.utils.Passengers;
import edu.neu.csye6200.utils.StringRes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class  BookLocalFlight extends JFrame {

    private JPanel contentPane;
    private JTable flightTable;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BookLocalFlight frame = new BookLocalFlight();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public BookLocalFlight() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 843, 419);
        setTitle("Book Local DomesticFlight");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Local DomesticFlight Schedule");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(28, 0, 679, 28);
        contentPane.add(lblNewLabel);

        String[] columns = {"DomesticFlight ID", "Time", "Date", "Daparture",
                "Arrival" , "Economy class Seats" , "Business class Seats" , "Time Duration"};

        DefaultTableModel obj=new DefaultTableModel(columns,0);

        for (int i = 0; i< LocalFlightSchedule.domesticFlightList.size() ; i++)
        {

            Object[] update= {LocalFlightSchedule.domesticFlightList.get(i).getFlightID() , LocalFlightSchedule.domesticFlightList.get(i).getDepartTime() , LocalFlightSchedule.domesticFlightList.get(i).getLandTime()
                    , LocalFlightSchedule.domesticFlightList.get(i).getDepartDestination() , LocalFlightSchedule.domesticFlightList.get(i).getLandDestination() ,
                    LocalFlightSchedule.domesticFlightList.get(i).getEconomySeats() , LocalFlightSchedule.domesticFlightList.get(i).getBusinessSeats() , LocalFlightSchedule.domesticFlightList.get(i).getDistance()};

            obj.addRow(update);
        }

        flightTable = new JTable(obj);
        JScrollPane scrollPane = new JScrollPane(flightTable);
        scrollPane.setBounds(10, 39, 764, 200);
        contentPane.add(scrollPane);

        JButton btnNewButton = new JButton("Cancel DomesticFlight");
        btnNewButton.addActionListener(e -> {

            for (Passengers x: SignUP.PassengerList)
            {
                if (x.getUsername().equals(SignUP.username.getText()))
                {
                    if (x.getBooked()==true)
                    {
                        double hour=Integer.valueOf((String) flightTable.getModel().getValueAt(flightTable.getSelectedRow(), 7));

                        double price=(hour*10000)+((hour*10000)*5/100);
                        JOptionPane.showMessageDialog(null, "Your flight has been cancelled successfully with a penalty of "+ (price*25/100));
                        SignUP.PassengerList.get(0).setBooked(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Please book your flight first.");
                    }
                }
            }
        });
        btnNewButton.setBounds(249, 250, 112, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Book DomesticFlight");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (flightTable.getSelectedRowCount()==1)
                {
                    String selectClass = JOptionPane.showInputDialog(null, "Enter '1' for Economy and '2' for Business class.",null);
                    int slctClass = Integer.valueOf(selectClass);

                    switch (slctClass)
                    {
                        case 1:
                        {
                            for (Passengers x: SignUP.PassengerList)
                            {
                                if (x.getUsername().equals(SignUP.username.getText()))
                                {
                                    if(x.getBooked()==true)
                                    {
                                        JOptionPane.showMessageDialog(null, "Your flight has already been booked against your Passport: "+x.getPassport());
                                    }
                                    if (Integer.valueOf((String) flightTable.getModel().getValueAt(flightTable.getSelectedRow(), 5)) > 0 )
                                    {
                                        String str = SignUP.username.getText() + "," +
                                                flightTable.getModel().getValueAt(flightTable.getSelectedRow(), 5) + "," +
                                                "Booked";

                                        CSVReader.addToCSV(StringRes.BOOKING, str);
                                        x.setBooked(true);
                                        JOptionPane.showMessageDialog(null, "Your flight has been booked against your Passport: "+x.getPassport());
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null, "This flight has no available seats in Economy class.");
                                    }

                                }
                            }
                            break;
                        }
                        case 2:
                        {
                            for (Passengers x: SignUP.PassengerList)
                            {
                                if (x.getUsername().equals(SignUP.username.getText()))
                                {
                                    if(x.getBooked()==true)
                                    {
                                        JOptionPane.showMessageDialog(null, "Your flight has already been booked against your Passport: "+x.getPassport());
                                    }
                                    if (Integer.valueOf((String) flightTable.getModel().getValueAt(flightTable.getSelectedRow(), 6)) > 0 )
                                    {
                                        x.setBooked(true);
                                        JOptionPane.showMessageDialog(null, "Your flight has been booked against your Passport: "+x.getPassport());
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null, "This flight has no available seats in Business class.");
                                    }
                                }
                            }

                            break;
                        }
                        default:
                        {
                            JOptionPane.showMessageDialog(null, "You entered an invalid input. Try again");
                            break;
                        }
                    }
                }
                else if(flightTable.getSelectedRowCount()==0)
                {
                    JOptionPane.showMessageDialog(null, "Please select a flight to book.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please select one flight at a time.");
                }
            }
        });
        btnNewButton_1.setBounds(127, 250, 111, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("View Ticket Price");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double hour=Integer.valueOf((String) flightTable.getModel().getValueAt(flightTable.getSelectedRow(), 7));

                double price=(hour*10000)+((hour*10000)*5/100);
                JOptionPane.showMessageDialog(null, "The cost for this flight is: "+price);
            }
        });
        btnNewButton_2.setBounds(371, 250, 136, 23);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton(StringRes.BACK.getValue());
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookingMenu obj=new BookingMenu();
                obj.setVisible(true);
                dispose();
            }
        });
        btnNewButton_3.setBounds(517, 250, 112, 23);
        contentPane.add(btnNewButton_3);
    }
}

