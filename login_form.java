/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahack;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 
  

public class login_form {

    /**
     * @param args the command line arguments
     */
	static String reg_no;
	static String password;
	static Connection c = null;
    static Statement stmt = null;
    public static void main(String[] args) {
        
      JFrame frame = new JFrame("Student Login");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();    
        // adding panel to frame
        frame.add(panel);
        /* calling user defined method for adding components
         * to the panel.
         */
        placeComponents(panel);

        // Setting the frame visibility to true
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* We will discuss about layouts in the later sections
         * of this tutorial. For now we are setting the layout 
         * to null
         */
        panel.setLayout(null);

        // Creating JLabel
        JLabel userLabel = new JLabel("Register Number");
        userLabel.setBounds(10,20,130,25);
        panel.add(userLabel);

        /* Creating text field where user is supposed to
         * enter user name.
         */
        JTextField RegNo = new JTextField(20);
        RegNo.setBounds(150,20,165,25);
        panel.add(RegNo);
        
        System.out.println(reg_no);

        // Same process for password label and text field.
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);
        

        /*This is similar to text field but it hides the user
         * entered data and displays dots instead to protect
         * the password like we normally see on login screens.
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150,50,165,25);
        panel.add(passwordText);
        
        System.out.println(password);

        // Creating login button
        JButton loginButton = new JButton("login now");
        loginButton.setBounds(10, 80, 150, 25);
        panel.add(loginButton);
        
        loginButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	reg_no=RegNo.getText();
            	password=new String(passwordText.getPassword());
           
            	try {
     		       Class.forName("org.postgresql.Driver");
     		       c = DriverManager.getConnection(
     		   					"jdbc:postgresql://127.0.0.1:5432/trash-it", "developer",
     		   					"prerna123");
     		      stmt = c.createStatement();
     		      String sql = "SELECT * FROM STUDENT WHERE NAME = \'"+reg_no+"\' AND PASSWORD = \'"+password+"\';";
     		      System.out.println(sql);
     		      ResultSet rs =stmt.executeQuery(sql);
     		      //rs.next();
     		      //int count=rs.getInt(1);
     		      //System.out.println(count);
     		      if(rs.next())
     		      {
     		    	 int reg=rs.getInt("REG_NO");
     		    	 user_details us=new user_details();
     	   		     us.start(reg);
     		      }
     		      
     		       
            	} catch ( Exception ee ) {
     		       System.err.println( ee.getClass().getName()+": "+ ee.getMessage() );
     		       System.exit(0);
     		    }
            	
            }
        });
        
        
        JButton resultsButton = new JButton("See allotment Status");
        resultsButton.setBounds(10, 110, 220, 25);
        panel.add(resultsButton);
        
        resultsButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	assignHostel  hs =new assignHostel();
                hs.start();
        }
        });
    }
}
      
        
         