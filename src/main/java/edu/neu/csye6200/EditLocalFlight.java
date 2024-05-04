package edu.neu.csye6200;
import edu.neu.csye6200.utils.DomesticFlight;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditLocalFlight extends JFrame {

    private final JTextField idField;
    private final JTextField timeField;
    private final JTextField dateField;
    private final JTextField departCityField;
    private final JTextField landCityField;
    private final JTextField economySeatsField;
    private final JTextField businessSeatsField;
    private final JTextField distanceField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                EditLocalFlight frame = new EditLocalFlight();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public EditLocalFlight() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 593, 382);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Edit DomesticFlight");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 11, 414, 20);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("DomesticFlight ID");
        lblNewLabel_1.setBounds(10, 36, 113, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Time");
        lblNewLabel_2.setBounds(10, 61, 113, 14);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("DomesticFlight Date");
        lblNewLabel_3.setBounds(10, 86, 113, 14);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Deaprture City");
        lblNewLabel_4.setBounds(10, 111, 113, 14);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Landing City");
        lblNewLabel_5.setBounds(10, 136, 113, 14);
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Economy Seats");
        lblNewLabel_6.setBounds(10, 161, 113, 14);
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Business Seats");
        lblNewLabel_7.setBounds(10, 186, 113, 14);
        contentPane.add(lblNewLabel_7);

        idField = new JTextField();
        idField.setBounds(133, 33, 86, 20);
        contentPane.add(idField);
        idField.setColumns(10);

        timeField = new JTextField();
        timeField.setBounds(133, 58, 86, 20);
        contentPane.add(timeField);
        timeField.setColumns(10);

        dateField = new JTextField();
        dateField.setBounds(133, 83, 86, 20);
        contentPane.add(dateField);
        dateField.setColumns(10);

        departCityField = new JTextField();
        departCityField.setBounds(133, 108, 86, 20);
        contentPane.add(departCityField);
        departCityField.setColumns(10);

        landCityField = new JTextField();
        landCityField.setBounds(133, 133, 86, 20);
        contentPane.add(landCityField);
        landCityField.setColumns(10);

        economySeatsField = new JTextField();
        economySeatsField.setBounds(133, 158, 86, 20);
        contentPane.add(economySeatsField);
        economySeatsField.setColumns(10);

        businessSeatsField = new JTextField();
        businessSeatsField.setBounds(133, 183, 86, 20);
        contentPane.add(businessSeatsField);
        businessSeatsField.setColumns(10);

        JButton btnNewButton = new JButton("Done");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (idField.getText().isEmpty() || timeField.getText().isEmpty() || dateField.getText().isEmpty() || departCityField.getText().isEmpty() ||
                        landCityField.getText().isEmpty() || economySeatsField.getText().isEmpty() || businessSeatsField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Fields cannot be empty");
                }
                else if(!economySeatsField.getText().matches("^\\d+(\\.\\d+)?"))
                {
                    JOptionPane.showMessageDialog(null, "Please enter integer input for Economy Seats.");
                }
                else if(!businessSeatsField.getText().matches("^\\d+(\\.\\d+)?"))
                {
                    JOptionPane.showMessageDialog(null, "Please enter integer input for Business Seats.");
                }
                else if(!distanceField.getText().matches("^\\d+(\\.\\d+)?"))
                {
                    JOptionPane.showMessageDialog(null, "Please enter integer input for Time Duration.");
                }
                else if (Integer.parseInt(economySeatsField.getText())>50)
                {
                    JOptionPane.showMessageDialog(null, "Economy seats cannot be greater than '50'");
                }
                else if (Integer.parseInt(businessSeatsField.getText())>10)
                {
                    JOptionPane.showMessageDialog(null, "Business seats cannot be greater than '10'");
                }
                else
                {
                    int row= LocalFlightSchedule.table.getSelectedRow();
                    System.out.println(row);
                    LocalFlightSchedule.table.setValueAt(idField.getText(), row, 0);
                    LocalFlightSchedule.table.setValueAt(timeField.getText(), row, 1);
                    LocalFlightSchedule.table.setValueAt(dateField.getText(), row , 2);
                    LocalFlightSchedule.table.setValueAt(departCityField.getText(), row , 3);
                    LocalFlightSchedule.table.setValueAt(landCityField.getText(), row , 4);
                    LocalFlightSchedule.table.setValueAt(economySeatsField.getText(), row , 5);
                    LocalFlightSchedule.table.setValueAt(businessSeatsField.getText(),row , 6);
                    LocalFlightSchedule.table.setValueAt(distanceField.getText(), row , 7);

                    DomesticFlight domesticFlight =new DomesticFlight(idField.getText() , timeField.getText() , dateField.getText() , departCityField.getText() , landCityField.getText() , economySeatsField.getText()
                            , businessSeatsField.getText() , distanceField.getText());
                    LocalFlightSchedule.domesticFlightList.set((row), domesticFlight);
                    JOptionPane.showMessageDialog(null, "Updated Successfully");

                    LocalFlightSchedule obj=new LocalFlightSchedule();
                    obj.setVisible(true);
                    dispose();
                }
            }
        });
        btnNewButton.setBounds(255, 207, 89, 23);
        contentPane.add(btnNewButton);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> {
            dispose();
            new InternationalFlightSchedule().setVisible(true);
        });
        cancel.setBounds(255, 240, 89, 23);
        contentPane.add(cancel);

        JLabel lblNewLabel_8 = new JLabel("Time Duration");
        lblNewLabel_8.setBounds(10, 211, 113, 14);
        contentPane.add(lblNewLabel_8);

        distanceField = new JTextField();
        distanceField.setBounds(133, 208, 86, 20);
        contentPane.add(distanceField);
        distanceField.setColumns(10);
    }
}
