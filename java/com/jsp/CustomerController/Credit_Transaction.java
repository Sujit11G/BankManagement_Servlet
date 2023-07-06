package com.jsp.CustomerController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Customer;
import com.jsp.services.CustomerServices;

@WebServlet("/creditAmount")
public class Credit_Transaction extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CustomerServices customerServices=new CustomerServices(); 
	
		String ID=req.getParameter("CustomerID"); 
		int id=Integer.parseInt(ID); 
		String AMOUNT=req.getParameter("creditAmount");
		double amount=Double.parseDouble(AMOUNT);
		
		Customer c_credit=customerServices.creditAmount(id, amount);
		if(c_credit!=null) {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body><h1>"+"Amount " + amount +" credited to your account. Avl Bal Rs: "+c_credit.getBalance()+"</h1></body></html>");
	
		}
	}
}
