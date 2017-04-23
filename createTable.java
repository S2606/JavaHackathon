package javahack;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class createTable {
	
	Connection c = null;
    Statement stmt = null;
	
	public void start(){
		try {
		       Class.forName("org.postgresql.Driver");
		       c = DriverManager.getConnection(
		   					"jdbc:postgresql://127.0.0.1:5432/trash-it", "developer",
		   					"prerna123");
		       System.out.println("Opened database successfully");

		       stmt = c.createStatement();
		       /*String sql = "CREATE TABLE STUDENT " +
			            "(REG_NO INT PRIMARY KEY     NOT NULL," +
			            " NAME           TEXT    NOT NULL, " +
			            " PASSWORD            TEXT     NOT NULL)";
		       stmt.executeUpdate(sql);*/
		       /*String sql2 = "CREATE TABLE REGISTER_CGPA_ROOM " +
			            "(REG_NO INT references STUDENT(REG_NO)," 
			            + "ROOM        TEXT     NOT NULL)";
		       stmt.executeUpdate(sql2);
		       String sql4 = "CREATE TABLE SUBJ " +
			            "(ID INT PRIMARY KEY     NOT NULL," +
			            " SUBJECT  TEXT NOT NULL,"
			            + "EXAM_DATE TEXT NOT NULL)";
		       stmt.executeUpdate(sql4);
		       String sql3 = "CREATE TABLE REGISTER_SUBJECT " +
			            "(REG_NO INT references STUDENT(REG_NO)," +
			            " SUBJECT_ID  INT  references SUB(ID))";
		       stmt.executeUpdate(sql3);*/
		       
		       stmt.close();
		       c.close();
		    } catch ( Exception e ) {
		       System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		       System.exit(0);
		    }
		    System.out.println("Table created successfully");
	}
	
	public static void main( String args[] ) {
		new createTable().start();
	}
    
}
