package com.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.Dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.req.Success;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             
		String path=request.getServletPath();
		switch(path)
		{
		case "/reg":
			getRegistrationpage(request,response);
			break;
		case "/log":
			getLoginpage(request,response);
			break;
		case "/RegCustomer":
			insertCustomer(request,response);
			break;	
		case "/login":
			login(request,response);
			break;
			
		
		default:
			getStartUpPage(request,response);
			break;
		}
	
	}

	
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException ,NullPointerException
	{

		String email=request.getParameter("tbemaillog");
		String pass=request.getParameter("tbpasslog");
		
		boolean b=DataAccess.login1(email, pass);
		if(b)
		{
			RequestDispatcher rd=request.getRequestDispatcher("customersuccess.jsp");
			
			
			Success s=new Success();
			
			request.setAttribute("successdetails",s);
				
			rd.forward(request, response);
			
		}
		else
		{
			getLoginpage(request, response);
			 
		}
		
	}

	private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
	{
		String name=request.getParameter("tbname");
		String email=request.getParameter("tbemail");
		long mobile=Long.parseLong(request.getParameter("tbtel"));
		String pass=request.getParameter("tbpass");
		String state=request.getParameter("ddlstates");
		
		
		Customer c=new Customer(name, email,mobile, pass, state);
		
		DataAccess.inserting(c);
		
	   try {
			RequestDispatcher rd=request.getRequestDispatcher("customerlogin.jsp");
			 rd.forward(request, response);
	     } 
	   catch (ServletException | IOException e) {
		e.printStackTrace();
	     }

		
		
	}


	private void getRegistrationpage(HttpServletRequest request, HttpServletResponse response) {
		try {
			RequestDispatcher rd=request.getRequestDispatcher("customerregistraton.jsp");

			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
		
	}


	private void getLoginpage(HttpServletRequest request, HttpServletResponse response) {
		try {
			RequestDispatcher rd=request.getRequestDispatcher("customerlogin.jsp");

			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			RequestDispatcher rd=request.getRequestDispatcher("customer_management.jsp");

			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

