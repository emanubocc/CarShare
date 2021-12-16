package daofactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql extends DaoFactory {
	
	
	private String DB_URL = "jdbc:mysql://localhost:3306/carshare";
	private String DB_USERNAME = "root";
	private String DB_PASSWORD = "root";
	private String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	//Deprecato 
	//private String DB_DRIVER = "com.mysql.jdbc.Driver";
	
	public Connection openConnection() {   
		try {
			
			Class.forName(DB_DRIVER).newInstance();
			Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			return connection;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	

}
