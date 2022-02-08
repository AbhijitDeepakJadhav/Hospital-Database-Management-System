package hospitaldatabase;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class Main_connectivity {

	private JFrame frame;
	private JLabel label_1;
	private JTextField user;
	private JLabel label_2;
	private JPasswordField pass;
	 Connection conn;
	 private JTextField dtb;
	 private JLabel lblNewLabel;
	 private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_connectivity window = new Main_connectivity();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Main_connectivity() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
   public void initialize() {
		frame = new JFrame("Login Page");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label_1 = new JLabel("user name :");
		label_1.setBounds(33, 98, 81, 16);
		frame.getContentPane().add(label_1);
		
		user = new JTextField();
		user.setBackground(Color.CYAN);
		user.setBounds(137, 95, 246, 22);
		frame.getContentPane().add(user);
		
		label_2 = new JLabel("password :");
		label_2.setBounds(33, 133, 81, 16);
		frame.getContentPane().add(label_2);
		
		pass = new JPasswordField();
		pass.setBackground(Color.CYAN);
		pass.setBounds(137, 130, 246, 22);
		frame.getContentPane().add(pass);
		
		JButton button_1 = new JButton("connect");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				connect();
			}
		});
		button_1.setBounds(273, 164, 110, 25);
		frame.getContentPane().add(button_1);
		
		dtb = new JTextField();
		dtb.setBackground(Color.CYAN);
		dtb.setColumns(10);
		dtb.setBounds(137, 60, 246, 22);
		frame.getContentPane().add(dtb);
		
		JLabel lblDatabaseName = new JLabel("Database name :");
		lblDatabaseName.setBounds(33, 63, 103, 16);
		frame.getContentPane().add(lblDatabaseName);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(33, 13, 337, 34);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("  Login to the Database :- ");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 337, 34);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
	}
	
	
	public void connect() {
		try {
			String database = dtb.getText();
			String driver="com.mysql.cj.jdbc.Driver";
	        String url="jdbc:mysql://localhost:3306/"+database;
			String username=user.getText();
			String password=pass.getText();
				Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
				String re="connected succesfully";
				JOptionPane.showMessageDialog(null, re);
				Database ob = new Database();
				ob.main(null);
                frame.dispose();
			}catch(Exception e) {
				System.out.println(e);
			JOptionPane.showMessageDialog(null, "incorrect info");
			pass.setText(null);}
	}
}



