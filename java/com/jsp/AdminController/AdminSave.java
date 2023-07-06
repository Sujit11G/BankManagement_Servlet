package com.jsp.AdminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Admin;
import com.jsp.services.AdminServices;

@WebServlet("/Admin_SignUp")
public class AdminSave extends HttpServlet{

	AdminServices adminServices=new AdminServices();
	Admin admin=new Admin();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("adminname");
		String email=req.getParameter("adminemail");
		String password=req.getParameter("adminpassword");
		
		admin.setName(name);
		admin.setEmail(email);
	    admin.setPassword(password);
	    
	    Admin a=adminServices.saveAdminDetails(admin);
	    
	    if(a!=null) {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body><h1>"+"Data get Saved Successfully"+"</h1></body></html>");
	    }
		
	}
}

