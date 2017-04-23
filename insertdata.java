package javahack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class insertdata {
	
	Connection c = null;
    Statement stmt = null;
	
	public void start(){
		try {
		       Class.forName("org.postgresql.Driver");
		       c = DriverManager.getConnection(
		   					"jdbc:postgresql://127.0.0.1:5432/trash-it", "developer",
		   					"prerna123");
		       c.setAutoCommit(false);
		       System.out.println("Opened database successfully");

		       	stmt = c.createStatement();
		         /*String sql = "INSERT INTO STUDENT "
		            + "VALUES (1,'15BIT0314', 'abcd' );";
		         stmt.executeUpdate(sql);
		         String sql2 = "INSERT INTO STUDENT "
				            + "VALUES (2,'15BIT0058', 'efgh' );";
				         stmt.executeUpdate(sql2);
				         */
		       	/*String sql = "INSERT INTO REG_CGPA "
		       			+ "VALUES (1, 8.97);";
		       	stmt.executeUpdate(sql);
		       	String sql2 = "INSERT INTO REG_CGPA "
		       			+ "VALUES (2, 8.08);";*/
		       	String sql = "INSERT INTO STUDENT "
			            + "VALUES (3,'15BIT0025', 'mnop' );";
		       	stmt.executeUpdate(sql);
				         stmt.close();
				         c.commit();
				         c.close();
		         
		       
		} catch ( Exception e ) {
		       System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		       System.exit(0);
		    }
		    System.out.println("Table data added successfully");
	}
	
	public static void main( String args[] ) {
		new insertdata().start();
	}

}
