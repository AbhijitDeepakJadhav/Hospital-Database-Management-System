package hospitaldatabase;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Database {

	private JFrame framdtb;


	Connection conn = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Database window = new Database();
					window.framdtb.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Database() {
		conn = Myconnection.myconnector();  //calling static method "myconnector" from class "Myconnection" for connection with database.. 
		initialize();
	}
	
	private void initialize() {
		framdtb = new JFrame("Main Menu");
		framdtb.getContentPane().setBackground(Color.WHITE);
		framdtb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framdtb.setBounds(100, 100, 1034, 420);


		framdtb.getContentPane().setLayout(null);
		
		
		
		JButton btnCreateTable = new JButton("Create table");
		btnCreateTable.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCreateTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					PreparedStatement create = conn.prepareStatement("create table if not exists hospitaldtb(Full_Name varchar(100),Address varchar(100),Contact varchar(255),Disease varchar(100),Consultant varchar(100),Date_and_time varchar(25),Next_Appointment varchar(25),Total_Treatement_Charge integer(5),primary key(Full_Name))");
					create.executeUpdate();
					JOptionPane.showMessageDialog(null, "Table created.......");
					}
				catch(Exception o) {System.out.println(o);}
			}
		});
		btnCreateTable.setBounds(75, 102, 227, 56);
		framdtb.getContentPane().add(btnCreateTable);
		
		JButton btnInsert = new JButton("Add Entry");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Insertdtb obj = new Insertdtb();
				obj.main(null);
				framdtb.dispose();
			}
		});
		btnInsert.setBounds(395, 102, 227, 56);
		framdtb.getContentPane().add(btnInsert);
		
		JButton btnSearch = new JButton("Search Entry");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Searchdtb ob =new Searchdtb();
				ob.main(null);
				framdtb.dispose();
			}
		});
		btnSearch.setBounds(718, 102, 227, 56);
		framdtb.getContentPane().add(btnSearch);
		
		JButton btnDeleteEntry = new JButton("Delete Entry");
		btnDeleteEntry.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDeleteEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Deletedtbe ob = new Deletedtbe();
				ob.main(null);
				framdtb.dispose();
			}
		});
		btnDeleteEntry.setBounds(75, 228, 227, 56);
		framdtb.getContentPane().add(btnDeleteEntry);
		
		JLabel lblNewLabel = new JLabel("MENU :-");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(75, 13, 227, 50);
		framdtb.getContentPane().add(lblNewLabel);
		
		JButton btnLoadDatabase = new JButton("Load Database");
		btnLoadDatabase.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLoadDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loaddtb obj = new Loaddtb();
				obj.main(null);
				framdtb.dispose();
			}
		});
		btnLoadDatabase.setBounds(718, 228, 227, 56);
		framdtb.getContentPane().add(btnLoadDatabase);
		
		JButton btnUpdateDatabase = new JButton("Update Database");
		btnUpdateDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Updatedtb obj = new Updatedtb();
				obj.main(null);
				framdtb.dispose();
			}
		});
		btnUpdateDatabase.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdateDatabase.setBounds(395, 228, 227, 56);
		framdtb.getContentPane().add(btnUpdateDatabase);
	}
}
