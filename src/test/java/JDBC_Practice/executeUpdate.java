package JDBC_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class executeUpdate {

	@Test
	public void Update() throws Throwable {

		Connection con = null;

		try {
			// step-1 register the driver
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);

			// step-2 connect to database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

			// step-3 create statement
			Statement stmt = con.createStatement();

			// step-4 execute query
			int result = stmt.executeUpdate(
					"insert into students_info(regno, firstname, middlename, lastname) values('5', 'raja', 'gow', 'h')");
			System.out.println(result);
			if (result == 1)
				System.out.println("data is added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// step-4 close the connection with the database
			System.out.println("finally block executed");
			con.close();

		}

	}

}
