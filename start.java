package javahack;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class start {
	

	public static void main(String[] argv) {

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/trash-it", "developer",
					"prerna123");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			System.out.println("Table being made");
			/*createTable cd=new createTable();
			cd.start();*/
			insertdata id=new insertdata();
			id.start();
	         
			
		} else {
			System.out.println("Failed to make connection!");
		}
	}
	
}
