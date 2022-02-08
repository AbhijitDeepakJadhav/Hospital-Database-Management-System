package hospitaldatabase;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Updatedtb {

	private JFrame framupdt;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
    Connection conn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updatedtb window = new Updatedtb();
					window.framupdt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Updatedtb() {
		conn = Myconnection.myconnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framupdt = new JFrame("Edit in Database");
		framupdt.setBounds(100, 100, 802, 660);
		framupdt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framupdt.getContentPane().setLayout(null);
		framupdt.getContentPane().setBackground(Color.WHITE);
		
		
		JLabel label = new JLabel("Full Name:");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(12, 50, 90, 16);
		framupdt.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Address:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(12, 100, 109, 16);
		framupdt.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Contact No:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(12, 150, 109, 16);
		framupdt.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Disease:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(12, 200, 109, 16);
		framupdt.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Consultant:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(12, 250, 109, 16);
		framupdt.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Date_time:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(12, 300, 109, 16);
		framupdt.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Next Appointment:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(12, 350, 148, 22);
		framupdt.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Total Charges:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_7.setBounds(12, 400, 136, 20);
		framupdt.getContentPane().add(label_7);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setColumns(10);
		textField.setBackground(Color.CYAN);
		textField.setBounds(182, 50, 378, 22);
		framupdt.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.CYAN);
		textField_1.setBounds(182, 100, 378, 22);
		framupdt.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.CYAN);
		textField_2.setBounds(182, 150, 378, 22);
		framupdt.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.CYAN);
		textField_3.setBounds(182, 200, 378, 22);
		framupdt.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.CYAN);
		textField_4.setBounds(182, 250, 378, 22);
		framupdt.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_5.setColumns(10);
		textField_5.setBackground(Color.CYAN);
		textField_5.setBounds(182, 300, 378, 22);
		framupdt.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_6.setColumns(10);
		textField_6.setBackground(Color.CYAN);
		textField_6.setBounds(182, 350, 378, 22);
		framupdt.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_7.setColumns(10);
		textField_7.setBackground(Color.CYAN);
		textField_7.setBounds(182, 400, 378, 22);
		framupdt.getContentPane().add(textField_7);
		
		JButton bsave = new JButton("Update");
		bsave.setFont(new Font("Tahoma", Font.BOLD, 18));
		bsave.setBounds(228, 562, 148, 38);
		framupdt.getContentPane().add(bsave);
		
		JButton bback = new JButton("BACK");
		bback.setFont(new Font("Tahoma", Font.BOLD, 18));
		bback.setBounds(412, 562, 148, 38);
		framupdt.getContentPane().add(bback);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(812, 204, 4, 15);
		framupdt.getContentPane().add(textArea);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_8.setColumns(10);
		textField_8.setBackground(Color.CYAN);
		textField_8.setBounds(182, 500, 378, 22);
		framupdt.getContentPane().add(textField_8);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fname;
				fname=textField_8.getText();
				
				try {
				PreparedStatement search=conn.prepareStatement("select * from hospitaldtb where Full_Name=?");
				search.setString(1, fname);
            
				ResultSet rs = search.executeQuery();
				while(rs.next())
				  {
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
					textField_3.setText(rs.getString(4));
					textField_4.setText(rs.getString(5));
					textField_5.setText(rs.getString(6));
					textField_6.setText(rs.getString(7));
					textField_7.setText(rs.getString(8));
					JOptionPane.showMessageDialog(null, "now you can edit the data");
				  }
				}catch(Exception a) {
					System.out.println(a);
					JOptionPane.showMessageDialog(null, a);}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSearch.setBounds(49, 562, 148, 38);
		framupdt.getContentPane().add(btnSearch);
		
		JLabel lblEnterFullName = new JLabel("Enter Full Name:");
		lblEnterFullName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterFullName.setBounds(12, 506, 158, 16);
		framupdt.getContentPane().add(lblEnterFullName);
		framupdt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framupdt.setBounds(32, 10, 590, 660);
		
		bsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String fname;
				fname=textField_8.getText();
				String fnewname=textField.getText();
				String address=textField_1.getText();
				String dise=textField_2.getText();
				String cons=textField_3.getText();
				String dt=textField_4.getText();
				String appoi=textField_5.getText();
				String contact=textField_6.getText();
				int tch=Integer.parseInt(textField_7.getText());
				PreparedStatement updt=conn.prepareStatement("update hospitaldtb set  Full_Name=?,Address=?,Contact=?,Disease=?,Consultant=?,Date_and_time=?,Next_Appointment=?,Total_Treatement_Charge=? where Full_Name = ?");
				updt.setString(1, fnewname);
				updt.setString(2, address);
				updt.setString(3, dise);
				updt.setString(4, cons);
				updt.setString(5, dt);
				updt.setString(6, appoi);
				updt.setString(7, contact);
				updt.setInt(8, tch);
				
				updt.setString(9, fname);
				updt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Data Updated Succesfully");
				}catch(Exception f){JOptionPane.showMessageDialog(null, f);}
			}
		});
		
		bback.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			
				Database obj = new Database();
				obj.main(null);
				framupdt.dispose();
				
			}
		});
		
	}
}
