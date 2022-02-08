package hospitaldatabase;
import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class Loaddtb {

	private JFrame frameload;
	private JTable table;
	
	Connection conn = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loaddtb window = new Loaddtb();
					window.frameload.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public Loaddtb() {
		conn = Myconnection.myconnector();  //calling static method "myconnector" from class "Myconnection" for connection with database.. 
        initialize();
		
	}

	private void initialize() {
		
		
		frameload = new JFrame("Load Database");
		frameload.getContentPane().setBackground(Color.WHITE);
		frameload.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameload.setBounds(100, 100, 1318, 549);
		
		frameload.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 104, 1276, 326);
		scrollPane.setBackground(Color.white);
		frameload.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Full Name", "Address", "Contact", "Disease", "Consultant", "Date and Time", "Next Appointment", "Treatment Charge"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setForeground(Color.black);
		table.setBackground(Color.white);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Back ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database ob = new Database();
				ob.main(null);
				frameload.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(1112, 443, 152, 46);
		frameload.getContentPane().add(btnNewButton_1);

		
		JButton btnLoadDatabase = new JButton("Load Database");
		btnLoadDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				try {
					PreparedStatement load = conn.prepareStatement("select * from hospitaldtb");
					ResultSet rs = load.executeQuery();
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					System.out.println("Tables Model created");
					while(rs.next())
					{
						model.addRow(new Object [] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)});
					}
				}catch(Exception a) {
					System.out.println(a);
					JOptionPane.showMessageDialog(null, "database loading failed");
				}
			
			}
		});
		btnLoadDatabase.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnLoadDatabase.setBounds(869, 443, 216, 46);
		frameload.getContentPane().add(btnLoadDatabase);
		
		JLabel lblNewLabel = new JLabel("    HOSPITAL DATABASE :-");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 13, 1300, 78);
		frameload.getContentPane().add(lblNewLabel);
	}
}
