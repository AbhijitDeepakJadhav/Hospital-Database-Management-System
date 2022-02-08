package hospitaldatabase;
import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.LineBorder;
public class Insertdtb {

	private JFrame framins;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	Connection conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insertdtb window = new Insertdtb();
					window.framins.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the Application
	 */
	public Insertdtb() {
		conn = Myconnection.myconnector();  //calling static method "myconnector" from class "Myconnection" for connection with database.. 
		initialize();
	}
	
	private void initialize() {
		framins = new JFrame("Insert in Database");
		framins.getContentPane().setBackground(Color.WHITE);
		framins.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framins.setBounds(100, 100, 590, 660);
		framins.getContentPane().setLayout(null);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFullName.setBounds(12, 75, 90, 16);
		framins.getContentPane().add(lblFullName);
		
		JLabel label_4 = new JLabel("Address:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(12, 125, 109, 16);
		framins.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Contact No:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(12, 175, 109, 16);
		framins.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Disease:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(12, 225, 109, 16);
		framins.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Consultant:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_7.setBounds(12, 275, 109, 16);
		framins.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Date_time:");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_8.setBounds(12, 325, 109, 16);
		framins.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("Next Appointment:");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_9.setBounds(12, 375, 148, 22);
		framins.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("Total Charges:");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_10.setBounds(12, 425, 136, 20);
		framins.getContentPane().add(label_10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_1.setBackground(Color.CYAN);
		textField_1.setColumns(10);
		textField_1.setBounds(182, 75, 378, 22);
		framins.getContentPane().add(textField_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_4.setBackground(Color.CYAN);
		textField_4.setColumns(10);
		textField_4.setBounds(182, 125, 378, 22);
		framins.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_5.setBackground(Color.CYAN);
		textField_5.setColumns(10);
		textField_5.setBounds(182, 175, 378, 22);
		framins.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_6.setBackground(Color.CYAN);
		textField_6.setColumns(10);
		textField_6.setBounds(182, 225, 378, 22);
		framins.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_7.setBackground(Color.CYAN);
		textField_7.setColumns(10);
		textField_7.setBounds(182, 275, 378, 22);
		framins.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_8.setBackground(Color.CYAN);
		textField_8.setColumns(10);
		textField_8.setBounds(182, 325, 378, 22);
		framins.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_9.setBackground(Color.CYAN);
		textField_9.setColumns(10);
		textField_9.setBounds(182, 375, 378, 22);
		framins.getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_10.setBackground(Color.CYAN);
		textField_10.setColumns(10);
		textField_10.setBounds(182, 425, 378, 22);
		framins.getContentPane().add(textField_10);
		
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				int tch;
				String fname,address,dise,cons,dt,appoi,contact;
				
				fname=textField_1.getText();
				address=textField_4.getText();
				dise=textField_5.getText();
				cons=textField_6.getText();
				dt=textField_7.getText();
				appoi=textField_8.getText();
				contact=textField_9.getText();
				tch=Integer.parseInt(textField_10.getText());
				try {
				PreparedStatement ins=conn.prepareStatement("insert into hospitaldtb values(?,?,?,?,?,?,?,?)");
				ins.setString(1, fname);
				ins.setString(2, address);
				ins.setString(3, dise);
				ins.setString(4, cons);
				ins.setString(5, dt);
				ins.setString(6, appoi);
				ins.setString(7, contact);
				ins.setInt(8,tch);
				ins.executeUpdate();
				JOptionPane.showMessageDialog(null, "data inserted ");
				textField_1.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				textField_8.setText(null);
				textField_9.setText(null);
				textField_10.setText(null);
				}catch(Exception z) {
					System.out.println(z);
					JOptionPane.showMessageDialog(null, z);}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(412, 500, 148, 63);
		framins.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Database ob = new Database();
				ob.main(null);
				framins.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(228, 500, 148, 63);
		framins.getContentPane().add(btnBack);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(812, 204, 4, 15);
		framins.getContentPane().add(textArea_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(71, 13, 438, 35);
		framins.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Insert Patient Info here:-");
		lblNewLabel.setBounds(0, 0, 438, 35);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
	}
}
