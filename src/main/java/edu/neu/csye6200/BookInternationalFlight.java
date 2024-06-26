package edu.neu.csye6200;
import edu.neu.csye6200.utils.Passengers;
import edu.neu.csye6200.utils.StringRes;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class BookInternationalFlight extends JFrame {

    private JPanel contentPane;
    private JTable flightTable;
    private String visaStatus="0";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BookInternationalFlight frame = new BookInternationalFlight();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Constructor for the BookInternationalFlight class.
     * Initializes the GUI components and sets up the flight schedule table.
     */
    public BookInternationalFlight() {
        // Setting up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 872, 433);
        setTitle("Book International DomesticFlight");
        // Creating the content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Adding GUI components such as labels, buttons, and table
        JLabel lblNewLabel = new JLabel("International DomesticFlight Schedule");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 11, 764, 23);
        contentPane.add(lblNewLabel);

        String[] columns = {"DomesticFlight ID", "Time", "Date", "Daparture",
                "Arrival" , "Economy class Seats" , "Business class Seats" , "Time Duration"};

        DefaultTableModel obj=new DefaultTableModel(columns,0);

        for (int i = 0; i< InternationalFlightSchedule.flightList2.size() ; i++)
        {

            Object[] update= {InternationalFlightSchedule.flightList2.get(i).getFlightID() , InternationalFlightSchedule.flightList2.get(i).getDepartTime() , InternationalFlightSchedule.flightList2.get(i).getLandTime()
                    , InternationalFlightSchedule.flightList2.get(i).getDepartDestination() , InternationalFlightSchedule.flightList2.get(i).getLandDestination() ,
                    InternationalFlightSchedule.flightList2.get(i).getEconomySeats() , InternationalFlightSchedule.flightList2.get(i).getBusinessSeats() , InternationalFlightSchedule.flightList2.get(i).getDistance()};

            obj.addRow(update);
        }

        flightTable = new JTable(obj);
        JScrollPane scrollPane = new JScrollPane(flightTable);
        scrollPane.setBounds(10, 39, 764, 200);
        contentPane.add(scrollPane);
        //Cancellation of a booked flight with a penalty.
        JButton btnNewButton = new JButton("Cancel DomesticFlight");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

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


            }
        });
        btnNewButton.setBounds(249, 250, 112, 23);
        contentPane.add(btnNewButton);
        //Booking of a flight based on user input.
        JButton btnNewButton_1 = new JButton("Book DomesticFlight");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (flightTable.getSelectedRowCount()==1)
                {
                    String visachoice= JOptionPane.showInputDialog(null,"Enter Y if you have Visa and N if you don't have Visa",null);
                    if(visachoice.equals("N")) {
                        JOptionPane.showMessageDialog(null,"Sorry you can't book a flight");
                    }
                    else if(visachoice.equals("Y")){
                        String userchoice= JOptionPane.showInputDialog(null,"Enter 1 for Economy class and 2 for Business Class",null);

                        int selectClass = Integer.valueOf(userchoice);

                        switch (selectClass)
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
                    else
                    {
                        System.out.println(visaStatus);
                        JOptionPane.showMessageDialog(null, "Please enter '1' or '2' only.");
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
        //Display the ticket price for the selected flight.
        JButton btnNewButton_2 = new JButton("View Ticket Price");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double hour=Integer.valueOf((String) flightTable.getModel().getValueAt(flightTable.getSelectedRow(), 7));

                double price=(hour*20000)+((hour*20000)*10/100);
                JOptionPane.showMessageDialog(null, "The cost for this flight is: "+price);
            }
        });
        btnNewButton_2.setBounds(371, 250, 131, 23);
        contentPane.add(btnNewButton_2);
        //Navigates back to the passenger menu.
        JButton btnNewButton_3 = new JButton(StringRes.BACK.getValue());
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookingMenu obj=new BookingMenu();
                obj.setVisible(true);
                dispose();
            }
        });
        btnNewButton_3.setBounds(543, 250, 112, 23);
        contentPane.add(btnNewButton_3);
    }
}
