package utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBUtil {
	
	public static Connection provideConnection() {
		
		Connection con=null;
		
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:5000/project","root","root");
			
		}catch(Exception e){}
		
		return con;

	}

}
