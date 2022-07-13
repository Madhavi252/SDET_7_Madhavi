package JDBC_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class executeQuery {

	@Test
	public void Query() throws Throwable {
		// step-1 Register the driver
		// step-2 connect to database
		Connection con = null;
		try {
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

			// step-3 create statement
			Statement stmt = con.createStatement();

			// step-4 execute query
			ResultSet result = stmt.executeQuery("select * from students_info;");
			while (result.next()) {
				System.out.println(result.getString(1) + " " + result.getString(2));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// step-5 close connection with database
			con.close();

		}

	}

}
