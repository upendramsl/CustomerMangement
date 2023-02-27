package com.techpalle.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.techpalle.model.Customer;

public class DataAccess
{
	public static Connection con=null;
	public static PreparedStatement ps=null;

public static void inserting(Customer c)
{
    try 
    {
		Class.forName("com.mysql.cj.jdbc.Driver");
	   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","upendra");
		String qry="insert into customer(name,email,mobile,password,state) values(?,?,?,?,?)";
		
		ps=con.prepareStatement(qry);
		
		ps.setString(1,c.getName());
		ps.setString(2,c.getEmail());
		ps.setLong(3,c.getMobile());
		ps.setString(4,c.getPassword());
		ps.setString(5,c.getState());
		
		
		
		ps.executeUpdate();
		
		
		
	} 
    catch (ClassNotFoundException e1) 
    {
		e1.printStackTrace();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
    finally
    {
    	try {
    		if(ps!=null)
    		{
			ps.close();
    		}
    		if(con!=null)
    		{
    			con.close();
    		}
		} 
    	
    	catch (SQLException e1) {
			e1.printStackTrace();
		}
    }
    
}
public static boolean login1(String email,String pass)
{
	Boolean ispresent=false;
	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","upendra");
			String qry="select email,password from customer where email=? and password=?";
			
			ps=con.prepareStatement(qry);
			ps.setString(1,email);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			
			ispresent=rs.next();
	  		}
	    catch (ClassNotFoundException e1) 
	    {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	    finally
	    {
	    	try {
	    		if(ps!=null)
	    		{
				ps.close();
	    		}
	    		if(con!=null)
	    		{
	    			con.close();
	    		}
			} 
	    	
	    	catch (SQLException e1) {
				e1.printStackTrace();
			}
	    }
	return ispresent;
	
}
}


