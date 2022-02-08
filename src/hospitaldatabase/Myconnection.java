package hospitaldatabase;
import java.sql.*;  //importing package for accessing database management system i.e. Mysql
import javax.swing.*;// importing this package for GUI designing..

public class Myconnection {                           
	public static Connection myconnector()         //static method for connection of database...    
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");    //accessing JDBC driver
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "manik@12345");
		return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
		    return null;
		}	
	}
}
