package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.CustomerJdbc;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;


@WebServlet("/")
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String path = request.getServletPath();
		switch(path)
		{
		case "/logCustomer":
			validateCustomer(request,response);
			break;
		case "/regCustomer":
			insertCustomer(request,response);
			break;
		case "/reg":
			getRegistrationPage(request,response);
			break;
		case "/log":
			getLoginPage(request,response);
			break;
			
			default:
				getStartUpPage(request,response);
				break;
		}
	}
	
	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	private void validateCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		String email=request.getParameter("tbemail");
		String pass=request.getParameter("tbpass");
		boolean res=CustomerJdbc.validatecustomer(email, pass);
		if(res)
		{
			
			try {
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				SuccessPage sp =new SuccessPage();
				request.setAttribute("successDetails", sp);
				rd.forward(request, response);
				
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			getLoginPage(request,response);
		}
	}

	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		int id = Integer.parseInt(request.getParameter("tbnum"));
		String name=request.getParameter("tbname");
		int age=Integer.parseInt(request.getParameter("tbage"));
		String email=request.getParameter("tbemail");
		String password=request.getParameter("tbpassword");
		
		Customer cus = new Customer(id, name, age, email, password);
		CustomerJdbc.inserting(cus);
		
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}



	private void getLogInPage(HttpServletResponse response, HttpServletRequest request)
	{
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
