package sms_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;


public class GetDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;

		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement statement = conn.createStatement();
			String query = "select * from project";
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				String value = result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getInt(6);
			System.out.println(value);
			}
		} 
		finally {
			conn.close();
		}
	}
}
