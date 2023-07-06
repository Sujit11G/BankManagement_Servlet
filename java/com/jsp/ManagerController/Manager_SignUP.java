package com.jsp.ManagerController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Manager;
import com.jsp.services.ManagerServices;

@WebServlet("/Manager_SignUp")
public class Manager_SignUP extends HttpServlet {
	Manager manager=new Manager();
	
	ManagerServices managerServices=new ManagerServices();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name=req.getParameter("managername");
		String email=req.getParameter("manageremail");
		String password=req.getParameter("managerpassword");
		
		manager.setName(name);
		manager.setEmail(email);
	    manager.setPassword(password);
	    
	    Manager m=managerServices.saveManagerDetails(manager);
	    
	    if(m!=null) {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body><h1>"+"Data get Saved Successfully"+"</h1></body></html>");
	    }
	}

}
