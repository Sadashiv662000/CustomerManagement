package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.techpalle.model.Customer;

public class CustomerJdbc
{
	static Connection  con=null;
	static PreparedStatement ps=null;
	static ResultSet rs = null;
	public static void inserting(Customer c)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle", "root", "admin");
			String qry="insert into customer(cname, Cage, Cemail, cpassword) values(?,?,?,?,?)";
			ps=con.prepareStatement(qry);
			ps.setInt(1, c.getCid());
			ps.setString(2, c.getCname());
			ps.setInt(3, c.getCage());
			ps.setString(4, c.getCemail());
			ps.setString(5, c.getCpassword());
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(ps !=null)
				{
					ps.close();
				}
				if(con != null)
				{
					con.close();
				}
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		
	}
	public static boolean validatecustomer(String email, String password)
	{
		boolean b = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle", "root", "admin");
			String qry="select email,password from customer where Cemail=? and cpassword=?";
			ps=con.prepareStatement(qry);
			ps.setString(1, email);
			ps.setString(2, password);
			rs=ps.executeQuery();
			
			b=rs.next();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs != null)
				{
					rs.close();
				}
				if(ps !=null)
				{
					ps.close();
				}
				if(con != null)
				{
					con.close();
				}
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		return b;
		
	}
	
	
}
