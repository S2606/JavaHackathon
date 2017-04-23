
package javahack;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 
  

public class user_details {

    /**
     * @param args the command line arguments
     */
	
	static Connection c = null;
    static Statement stmt = null;
    static int reg_no;
    static int CGPA=8;
    static String room_choice;
    
	public void start(int regno)
	{
		reg_no=regno;
		JFrame frame = new JFrame("Auto VTOP");
        // Setting the width and height of frame
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Creating panel. This is same as a div tag in HTML
         * We can create several panels and add them to specific 
         * positions in a JFrame. Inside panels we can add text 
         * fields, buttons and other components.
         */
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
        

        try {
		       Class.forName("org.postgresql.Driver");
		       c = DriverManager.getConnection(
		   					"jdbc:postgresql://127.0.0.1:5432/trash-it", "developer",
		   					"prerna123");
		      stmt = c.createStatement();
		      String sql = "SELECT * FROM REG_CGPA WHERE REG_NO = "+reg_no+";";
		      System.out.println(sql);
		      ResultSet rs =stmt.executeQuery(sql);
		      //rs.next();
		      //int count=rs.getInt(1);
		      //System.out.println(count);
		      if(rs.next())
		      {
		    	 CGPA=rs.getInt("CGPA");
		      }
		      
		       
     	} catch ( Exception ee ) {
		       System.err.println( ee.getClass().getName()+": "+ ee.getMessage() );
		       System.exit(0);
		    }
        
        // Creating JLabel
        JLabel userLabel = new JLabel(" Hello Register Number");
        userLabel.setBounds(10,20,130,25);
        panel.add(userLabel);
        
        
        
        JLabel user_cgpa = new JLabel(" Your CGPA is "+CGPA);
        user_cgpa.setBounds(10,40,130,25);
        panel.add(user_cgpa);

      
      JComboBox roomType1 = new JComboBox();   
      roomType1.addItem("1AC K Block");
      roomType1.addItem("2AC K Block");
      roomType1.addItem("6AC K Block");
      roomType1.addItem("1NAC K Block");
      roomType1.addItem("2NAC K Block");
      roomType1.addItem("6NAC K Block");
      roomType1.addItem("1AC L Block");
      roomType1.addItem("2AC L Block");
      roomType1.addItem("6AC L Block");
      roomType1.addItem("1NAC L Block");
      roomType1.addItem("2NAC L Block");
      roomType1.addItem("6NAC L Block");
      roomType1.setBounds(30, 100, 200, 20);
      panel.add(roomType1);
      
      JComboBox roomType2 = new JComboBox();
      roomType2.addItem("1AC K Block");
      roomType2.addItem("2AC K Block");
      roomType2.addItem("6AC K Block");
      roomType2.addItem("1NAC K Block");
      roomType2.addItem("2NAC K Block");
      roomType2.addItem("6NAC K Block");
      roomType2.addItem("1AC L Block");
      roomType2.addItem("2AC L Block");
      roomType2.addItem("6AC L Block");
      roomType2.addItem("1NAC L Block");
      roomType2.addItem("2NAC L Block");
      roomType2.addItem("6NAC L Block");
      roomType2.setBounds(30, 130, 200, 20);
      panel.add(roomType2);
      
      JComboBox roomType3 = new JComboBox();
      roomType3.addItem("1AC K Block");
      roomType3.addItem("2AC K Block");
      roomType3.addItem("6AC K Block");
      roomType3.addItem("1NAC K Block");
      roomType3.addItem("2NAC K Block");
      roomType3.addItem("6NAC K Block");
      roomType3.addItem("1AC L Block");
      roomType3.addItem("2AC L Block");
      roomType3.addItem("6AC L Block");
      roomType3.addItem("1NAC L Block");
      roomType3.addItem("2NAC L Block");
      roomType3.addItem("6NAC L Block");
      roomType3.setBounds(30, 160, 200, 20);
      panel.add(roomType3);
      
      
      JLabel statusLabel;
      statusLabel = new JLabel("",JLabel.CENTER);   
      statusLabel.setBounds(120, 225, 400, 30);
    
      
      JButton showButton = new JButton("Show");
       showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "";
                if (roomType1.getSelectedIndex() != -1) {
                    data = "Room Selected: "
                            + roomType1.getItemAt
                          (roomType1.getSelectedIndex());
                    System.out.println(roomType1.getSelectedIndex());
                    room_choice = Integer.toString(roomType1.getSelectedIndex());
                }
                if (roomType2.getSelectedIndex() != -1) {
                    data = data + 
                            (roomType2.getItemAt(roomType2.getSelectedIndex()));
                    System.out.println(roomType2.getSelectedIndex());
                    room_choice = room_choice + "&" +Integer.toString(roomType2.getSelectedIndex());
                    
                }
                
                  if (roomType3.getSelectedIndex() != -1) {
                    data = data + (roomType3.getItemAt(roomType3.getSelectedIndex()));
                      
                    System.out.println(roomType3.getSelectedIndex());
                    room_choice = room_choice + "&" +Integer.toString(roomType3.getSelectedIndex());
                    try {
         		       Class.forName("org.postgresql.Driver");
         		       c = DriverManager.getConnection(
         		   					"jdbc:postgresql://127.0.0.1:5432/trash-it", "developer",
         		   					"prerna123");
         		      c.setAutoCommit(false);
         		      stmt = c.createStatement();
         		     String sql = "INSERT INTO REGISTER_CGPA_ROOM "
     		       			+ "VALUES ("+reg_no+", \'"+room_choice+"\');";
         		     System.out.println(sql);
     		       	stmt.executeUpdate(sql);
     		       stmt.close();
			         c.commit();
			         c.close();
         		    System.out.println("SUCCESSFUL!");
         		      
         		       
              	} catch ( Exception ee ) {
         		       System.err.println( ee.getClass().getName()+": "+ ee.getMessage() );
         		       System.exit(0);
         		    }
                  }
                             
                statusLabel.setText(data);
            }
 
        }); 
      showButton.setBounds(350, 100, 200, 25); 
      panel.add(showButton);
      
      panel.add(statusLabel);
	}
	
    public static void main(String[] args) {
        
      
    }

}
        
        
        
        
        
        
         