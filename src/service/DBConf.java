
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConf {
    
    private static String url = "jdbc:mysql://localhost:3306/cosmeticStore";
    private static String userName = "root";
    private static String password = "";
    private static Connection con;
    
    public static Connection getConnection(){
        try {
			
		Class.forName("com.mysql.jdbc.Driver");
			
		con = DriverManager.getConnection(url, userName, password);
			
	}
	catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
           
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
		
	return con;
    }
    
    
    
}
