package com.jsp.ManagerController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jsp.dto.Manager;
import com.jsp.services.ManagerServices;

@WebServlet("/manager_id")
public class Manager_Login extends HttpServlet  {

	ManagerServices managerServices=new ManagerServices();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String ID=req.getParameter("managerId");
		int id=Integer.parseInt(ID);
		
		String Password=req.getParameter("managerpassword");
		
		   
		Manager m=managerServices.fetchManagerDetails(id);
		 
		if(m!=null&&m.getPassword().equals(Password)) {

			RequestDispatcher requestDispatcher=req.getRequestDispatcher("Manager_Page.jsp");
			
			requestDispatcher.forward(req, resp);
		}else {
		      
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body><h1>"+"Invalid ID or Password"+"</h1></body></html>");
		}
		  
	}
}
