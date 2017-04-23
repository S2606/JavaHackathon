package javahack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class assignHostel {
	
	static Connection c = null;
    static Statement stmt = null;
	
	int array_index = 0; 
	ArrayList<Integer> a=new ArrayList<>();
	int choice_pr1[]=new int[10];
	int choice_pr2[]=new int[10];
	int choice_pr3[]=new int[10];
	
	String student[]=new String[10];
	int reg_no[]=new int[10];
	int cgpa[]=new int[10];
	public void start()
	{
		try {
		       Class.forName("org.postgresql.Driver");
		       c = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/trash-it", "developer","prerna123");
		      stmt = c.createStatement();
		      String sql = "SELECT * FROM REGISTER_CGPA_ROOM;";
		      System.out.println(sql);
		      ResultSet rs =stmt.executeQuery(sql);
		      while(rs.next())
		      {
		    	 
		    	 int reg= rs.getInt("REG_NO");
		    	 String room = rs.getString("ROOM");
		    	 //user_details us=new user_details();
	   		     //us.start(reg);
		    	 System.out.println(room);
		    	 String[] choices = room.split("&");
		    	 choice_pr1[array_index] = Integer.parseInt(choices[0]);
		    	 choice_pr2[array_index] = Integer.parseInt(choices[1]);
		    	 choice_pr3[array_index] = Integer.parseInt(choices[2]);
	   		     reg_no[array_index] = rs.getInt("REG_NO");
	   		     array_index++; 
		      }
		    System.out.println(array_index);  
		       
  	        } catch ( Exception ee ) {
		       System.err.println( ee.getClass().getName()+": "+ ee.getMessage() );
		       System.exit(0);
		    }
 	
 	         
 	      for(int i=0;i<array_index;i++)
 	      {
 	    	 try {
 			       Class.forName("org.postgresql.Driver");
 			       c = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/trash-it", "developer","prerna123");
 			      stmt = c.createStatement();
 			      String sql = "SELECT * FROM STUDENT WHERE REG_NO = "+reg_no[i]+";";
 			      System.out.println(sql);
 			      ResultSet rs =stmt.executeQuery(sql);
 			      if(rs.next())
 			      {
 			          
 			         student[i]=rs.getString("NAME");
 			      }
 	    	} catch ( Exception ee ) {
 		       System.err.println( ee.getClass().getName()+": "+ ee.getMessage() );
 		       System.exit(0);
 		    } 
 	    	try {
			       Class.forName("org.postgresql.Driver");
			       c = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/trash-it", "developer","prerna123");
			      stmt = c.createStatement();
			      String sql = "SELECT CGPA FROM REG_CGPA WHERE REG_NO = "+reg_no[i]+";";
			      System.out.println(sql);
			      ResultSet rs =stmt.executeQuery(sql);
			      if(rs.next())
			      {
			          cgpa[i]=rs.getInt("CGPA");
			      }
	    	} catch ( Exception ee ) {
		       System.err.println( ee.getClass().getName()+": "+ ee.getMessage() );
		       System.exit(0);
		    } 
 	      }
 	
 	
 	
     int[] hostel_capacity = {3,3,3,3,3,3,3,3};
     //String[] student = {"a","b","c","d","e","f","g","h"};

     String[]  hostel_name = {"1AC K","2AC K","6AC k","1NAC k","2NAC k","6NAC k","1AC L","2AC L","6AC L","1NAC L","2NAC L","6NAC L"};
     //float[] cgpa = {1,2,3,4,5,6,7,8};
     
     for(int i=0;i< array_index; i++)
     {
         for(int j = 0; j < (array_index - i -1); j++ )
         {
             if( cgpa[j] < cgpa[j+1])
             {
                 int temp = cgpa[j];
                 cgpa[j] = cgpa[j+1];
                 cgpa[j+1] = temp;
                 
                 String temp_reg = student[j];
                 student[j] = student[j+1];
                 student[j+1] = temp_reg;
                 
                 int ptemp = choice_pr1[j];
                 choice_pr1[j] = choice_pr1[j+1];
                 choice_pr1[j+1] = ptemp;
                 
                 ptemp = choice_pr2[j];
                 choice_pr2[j] = choice_pr2[j+1];
                 choice_pr2[j+1] = ptemp;
                 
                 ptemp = choice_pr3[j];
                 choice_pr3[j] = choice_pr3[j+1];
                 choice_pr3[j+1] = ptemp;
                 
                 
                      
             }
         }
     }
     
     int n = student.length; 
     int assigned_hostel[] = new int[array_index];
     for(int i=0 ; i < array_index; i++)
     {
         if (hostel_capacity[choice_pr1[i]]  > 0)
         {
             assigned_hostel[i] = choice_pr1[i];
             hostel_capacity[choice_pr1[i]]--; 
         }
         else if (hostel_capacity[choice_pr2[i]]  > 0)
         {
             assigned_hostel[i] = choice_pr2[i];
             hostel_capacity[choice_pr2[i]]--;
         }
         else if (hostel_capacity[choice_pr3[i]]  > 0)
         {
             assigned_hostel[i] = choice_pr3[i];
             hostel_capacity[choice_pr3[i]]--;
         }
         else
             assigned_hostel[i] = -1; 
         
      }
     
     System.out.println("Assigned Hostels are: ");
     for(int i =0 ;i < array_index; i++)
     {
         System.out.println("RegNo: "+student[i]+" HOSTEL ASSIGNED "+hostel_name[assigned_hostel[i]]);
     }
     

 }
	
    public static void main(String []args)
    {
    	new assignHostel().start();
    }
    	
}
