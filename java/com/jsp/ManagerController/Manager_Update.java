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

@WebServlet("/UpdateManager")
public class Manager_Update extends HttpServlet {

	ManagerServices managerServices=new ManagerServices();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ManagerID=req.getParameter("manager_Id");
		int id=Integer.parseInt(ManagerID);
		String email=req.getParameter("manageremail");
		String password=req.getParameter("managerpassword");
		
		Manager manager=managerServices.fetchManagerDetails(id);
		
		if(manager!=null) {
			manager.setEmail(email);
			manager.setPassword(password);
		}
		
		Manager update_manager=managerServices.updateManagerData(id, email, password);
		
		if(update_manager!=null) {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body><h1>"+"Upadted Successfully!!"+"</h1></body></html>");
		}
		else {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body><h1>"+"Somthing went wrong..."+"</h1></body></html>");
		}
	}
}
