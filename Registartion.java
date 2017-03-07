
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




class Registration_Demo
{
	String emails;
	String username;
	String collegename;
	String pwd;
	
	

	public Registration_Demo(String username, String collegename,String pwd) {
		super();
		this.username = username;
		this.collegename = collegename;
		this.pwd=pwd;
	}



	public void emailvalidation() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter Email ID");
		String E_id=sc.nextLine();
		//ArrayList<String> al=new ArrayList<String>();
		//al.add(E_id);
		
		
		String regex = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}";
		 
		Pattern pattern = Pattern.compile(regex);
		 
		
		
		    Matcher matcher = pattern.matcher(E_id);
		    boolean flag=matcher.matches();
		    
		       if(flag)
		       {
		    	   System.out.println("Email is valid");
		    	   connection(E_id);
		       }
		       else
		       {
		    	   System.out.println("Email is not valid");
		    	   
		    	   emailvalidation();
		       }
		       //emailvalidation();
			
		       //connection(E_id);
		
		    
		}
		//connection(E_id);
		

	
	public void connection(String E_id) throws ClassNotFoundException, SQLException
	{
	ConnectionMysql connec=new ConnectionMysql();
	connec.getConnection(username,collegename,E_id,pwd);
	}
	
	
	
}

public class Registartion {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		System.out.println("Welcome to Registartion");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User Name");
		String U_name=sc.nextLine();
		
		
		//Registration_Demo r1=new Registration_Demo();
		//r1.emailvalidation();
		
		System.out.println("Enter college name");
		String C_name=sc.nextLine();
		
		System.out.println("Enter password");
		String pwd=sc.nextLine();
		
		
		Registration_Demo r1=new Registration_Demo(U_name,C_name,pwd);
		r1.emailvalidation();
		
		//ConnectionMysql connec=new ConnectionMysql();
		//connec.getConnection(U_name,C_name,email);
		
		
		}
	
}
