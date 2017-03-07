import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
	public static void main(String[] args) throws SQLException
	{
		ArrayList uname=new ArrayList();
		ArrayList password=new ArrayList();
		String query;
		System.out.println("Welcome to login page");
		
		//Scanner sc=new Scanner(System.in);
		System.out.println("Enter username");
		Scanner sc=new Scanner(System.in);
		String u_name=sc.nextLine();
		
		System.out.println("Enter password");
		String p_wd=sc.nextLine();
		
		try 
		{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Test", "root", "root");
            Statement stmt=con.createStatement();
            
            query="SELECT username,pwd from Studentdb;";
            stmt.executeQuery(query); 
            ResultSet rs = stmt.getResultSet(); 
            
            while(rs.next())
        	{
        	  uname.add(rs.getString("username")); 
        	 password.add(rs.getString("pwd")); 
        	}
        	if(uname.contains(u_name)&& password.contains(p_wd))
        	{ 
        		System.out.println("Login success"); 
        		//login = true; 
        	} 
        	else 
        	{
        		System.out.println("Login failed, Please enter the valid credentials");
        	}
        	
            

}catch (InstantiationException e) 
		{ 
	e.printStackTrace(); 
} 
catch (IllegalAccessException e)
 { 
	e.printStackTrace(); 
} catch (ClassNotFoundException e)
 { 
	e.printStackTrace(); 
} catch (SQLException e) 
	{ 
		e.printStackTrace(); 
	} 
}

}
