
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;





public class ConnectionMysql {
	
	public void getConnection(String username,String collegename,String emailid,String pwd) throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.jdbc.Driver");      

	        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root","root");      
	        Statement stmt=(Statement) con.createStatement(); 
	        PreparedStatement ps=con.prepareStatement("insert into Studentdb values(?,?,?,?)");
	        ps.setString(1, username);
	        ps.setString(2, collegename);
	        ps.setString(3, emailid);
	        ps.setString(4, pwd);
	        
	        int res=ps.executeUpdate();
	        if(res==0)
	        {
	        	System.out.println("not inserted");
	        }
	        else
	        {
	        	System.out.println("inserted");
	        }
	        ps.close();
	        con.close();
	        	
	        	
	        }
	        
	        //Registartion reg=new Registartion();
	        //reg.last();
	        //System.out.println("All Right , We got your entry");  
}
