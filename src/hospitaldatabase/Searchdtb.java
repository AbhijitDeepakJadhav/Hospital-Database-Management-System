package hospitaldatabase;
import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;



public class Searchdtb {

	private JFrame framsrch;
	private JTextField textField;

	Connection conn = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searchdtb window = new Searchdtb();
					window.framsrch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	public Searchdtb() {
		conn = Myconnection.myconnector();  //calling static method "myconnector" from class "Myconnection" for connection with database.. 
		initialize();
}
	
	public void initialize() {
		framsrch = new JFrame("Search in Database");
		framsrch.getContentPane().setBackground(Color.WHITE);
		framsrch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framsrch.setBounds(100, 100, 1040, 569);
		framsrch.getContentPane().setLayout(null);
		
		JTextArea textarea = new JTextArea();
		textarea.setFont(new Font("Courier New", Font.ITALIC, 14));
		textarea.setForeground(new Color(0, 0, 0));
		textarea.setBounds(25, 193, 984, 312);
		framsrch.getContentPane().add(textarea);

		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			String fname;
				fname=textField.getText();
				
				try {
				PreparedStatement search=conn.prepareStatement("select * from hospitaldtb where Full_Name=?");
				search.setString(1, fname);
            
				ResultSet rs = search.executeQuery();
				while(rs.next())
				  {
			
					  textarea.setText("\n"+"\t"+"\n"+"Name :-                "+rs.getString(1)+"\n"+"\t"+"\n"+"Address :-             "+rs.getString(2)+"\n"+"\t"+"\n"+"Contact no :-          "+rs.getString(3)+"\n"+"\t"+"\n"+"Disease :-             "+rs.getString(4)+"\n"+"\t"+"\n"+"Consultant :-           "+rs.getString(5)+"\n"+"\t"+"\n"+"Date and Time :-       "+rs.getString(6)+"\n"+"\t"+"\n"+"Next Appointment D&T:- "+rs.getString(7)+"\n"+"\t"+"\n"+"Total Amount Paid :-   "+rs.getInt(8));
				  }
				}catch(Exception a) {
					System.out.println(a);
					JOptionPane.showMessageDialog(null, a);}
			}
		});
		btnNewButton.setBounds(380, 133, 133, 25);
		framsrch.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(132, 13, 605, 75);
		framsrch.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Search by Name ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full name:-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(25, 127, 121, 37);
		framsrch.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(158, 129, 175, 37);
		framsrch.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Database ob = new Database();
				ob.main(null);
				framsrch.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(720, 133, 133, 25);
		framsrch.getContentPane().add(btnBack);
		
		JButton button = new JButton("Print");
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(550, 133, 133, 25);
		framsrch.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
try
{
	boolean a = textarea.print();
	if(a)
	{
		JOptionPane.showMessageDialog(null, "Done printing", "Information", JOptionPane.INFORMATION_MESSAGE);
	}else {
		JOptionPane.showMessageDialog(null, "Printing", "Printer", JOptionPane.ERROR_MESSAGE);
	}
}catch(PrinterException e) {JOptionPane.showMessageDialog(null, e);}
			}
		});
	
	}
}
