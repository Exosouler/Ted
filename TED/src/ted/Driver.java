package ted;
import java.sql.*;
public class Driver {

	private Connection connection = null; 
	private PreparedStatement stmt = null;
	void Connect(){
		
		try {
		    String connectionURL = "jdbc:mysql://localhost/db";
		    
		    Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		    connection = DriverManager.getConnection(connectionURL, "root", "");
		    if(!connection.isClosed())
		         System.out.println("Successfully connected to " + "MySQL server using TCP/IP...");
		 //   connection.close();
		}catch(Exception ex){
			System.out.println("Unable to connect to database"+ex);
		}  		
		
	}
	void Close(){
		try {
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("Unable to connect to database"+e);
		}
		connection = null;
	}
	boolean Checkuser(String Name,String Email) {
		ResultSet result=null;
		try {
		stmt = connection.prepareStatement("Select * From User where Username = ? or Email = ?");
		stmt.setString(1, Name);
	    stmt.setString(2, Email);
		
	    result = stmt.executeQuery();
	    if (result!=null && result.next()==true)
	    	return false;
	    else
	    	return true;	    
	    
	    
		} catch (SQLException e) {
			System.out.println("Unable to execute"+e);	
			
			return false;
		}

	 
	}
	void insertUser(String name,String email){
		try {
	    stmt = connection.prepareStatement("INSERT INTO User (Username, Email) values (?, ?)");
	    stmt.setString(1, name);
	    stmt.setString(2, email);	    
		stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Unable to execute"+e);			
		}
		
	}
	
}
