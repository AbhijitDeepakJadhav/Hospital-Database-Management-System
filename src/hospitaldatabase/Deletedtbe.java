package hospitaldatabase;
import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Deletedtbe extends JFrame {

	private JFrame framdel;
	private JTextField dtext;
	Connection conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deletedtbe window = new Deletedtbe();
					window.framdel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Deletedtbe() {
		conn = Myconnection.myconnector();  //calling static method "myconnector" from class "Myconnection" for connection with database.. 
        initialize();
	}
	
	public void initialize()
	{
		framdel = new JFrame("Delete From Database");
		framdel.getContentPane().setBackground(Color.WHITE);
		framdel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framdel.setBounds(100, 100, 597, 327);
		framdel.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(106, 34, 312, 39);
		framdel.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Enter Name to Delete Entry :");
		lblNewLabel.setBounds(0, 0, 338, 33);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		dtext = new JTextField();
		dtext.setForeground(Color.BLACK);
		dtext.setBackground(Color.CYAN);
		dtext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dtext.setBounds(106, 110, 354, 39);
		framdel.getContentPane().add(dtext);
		dtext.setColumns(10);
		
		conn = Myconnection.myconnector();
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		String name;
		name = dtext.getText();
		try {
		PreparedStatement del = conn.prepareStatement("delete from hospitaldtb where Full_Name = ?");
		del.setString(1, name);
		del.executeUpdate();
		JOptionPane.showMessageDialog(null, " deleted "+name);
		dtext.setText(null);
		}catch(Exception a) {JOptionPane.showMessageDialog(null, "cannot delete");}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(377, 200, 139, 45);
		framdel.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(65, 200, 139, 45);
		framdel.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {Database ob = new Database();
			ob.main(null);
			framdel.dispose();
			}
		});
	}

}
