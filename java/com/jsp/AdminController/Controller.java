package com.jsp.AdminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class Controller extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String register=req.getParameter("register");
		String login=req.getParameter("login");
		 String customer = req.getParameter("customer");
	        String manager = req.getParameter("manager");

	        if (register != null) {
	            
	        	RequestDispatcher requestDispatcher=req.getRequestDispatcher("AdminSignIN.jsp");
				
				requestDispatcher.forward(req, resp);
	        } else if (login != null) {
	        	RequestDispatcher requestDispatcher=req.getRequestDispatcher("AdminLogin.jsp");
				
				requestDispatcher.forward(req, resp);
	        } else if (customer != null) {
	        	RequestDispatcher requestDispatcher=req.getRequestDispatcher("All_Customer.jsp");
				
				requestDispatcher.forward(req, resp);
	        } else if (manager != null) {
	        	RequestDispatcher requestDispatcher=req.getRequestDispatcher("All_Manager.jsp");
				
				requestDispatcher.forward(req, resp);
	        }
		
	}

}

