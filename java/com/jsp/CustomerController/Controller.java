package com.jsp.CustomerController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customer")
public class Controller extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String register=req.getParameter("register");
		String login=req.getParameter("login");
		String update=req.getParameter("update");
		String transcation=req.getParameter("transcation");
		
		
		if(register!=null) {
			
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("Customer_SignUp.jsp");
			
			requestDispatcher.forward(req, resp);
		}else
		if(transcation!=null) {
				
		}else
		if(update!=null) {
					
	    }else
		if(login!=null) {

			RequestDispatcher requestDispatcher=req.getRequestDispatcher("Customer_Login.jsp");
			
			requestDispatcher.forward(req, resp);
						
		}
	}

}
