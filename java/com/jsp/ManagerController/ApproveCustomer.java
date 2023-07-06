package com.jsp.ManagerController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Customer;
import com.jsp.dto.Manager;
import com.jsp.services.CustomerServices;
import com.jsp.services.ManagerServices;

@WebServlet("/approveCustomer")
public class ApproveCustomer  extends HttpServlet{
	
	ManagerServices managerServices=new ManagerServices();
	CustomerServices customerServices=new CustomerServices();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String customer_ID=req.getParameter("customerId");
		int id=Integer.parseInt(customer_ID);
		
		String manager_ID=req.getParameter("manager_ID");
		int id2=Integer.parseInt(manager_ID);
		
		Manager manager=managerServices.fetchManagerDetails(id2);
		Customer customer=customerServices.getCustomerByID(id);
		
		
			
			if(manager.getId()==customer.getManager().getId())
			{
				if(customer.getStatus().equals("Block")) 
				{
				customer.setStatus("Approve");
				customerServices.updateCustomer(customer);
				PrintWriter printWriter=resp.getWriter();
				printWriter.write("<html><body><h1>"+" Customer is now Approve! "+"</h1></body></html>");
				
				}else if(customer.getStatus().equals("Approve"))  {
					 PrintWriter printWriter=resp.getWriter();
						printWriter.write("<html><body><h1>"+" Customer is already Approved "+"</h1></body></html>");
				
				 }
			}else {
				PrintWriter printWriter=resp.getWriter();
				printWriter.write("<html><body><h1>"+manager.getName()+" you are not Authorized To Approve "+customer.getId()+" customer"+"</h1></body></html>");
		
			}
		
		 
		
		
		
	}

}
