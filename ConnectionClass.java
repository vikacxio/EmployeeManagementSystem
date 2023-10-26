package employeeManagementSystem;

import java.sql.*;

public class ConnectionClass {
    
    Connection con;
    Statement stm;
    ConnectionClass() {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/employeeManagement","root","Vikac@123");  
	
		
		stm=con.createStatement();  
		
		
	}
	catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    
    public static void main(String[] args) {
	new ConnectionClass();
    }
    

}
