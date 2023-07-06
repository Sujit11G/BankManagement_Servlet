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

@WebServlet("/withdrawAmount")
public class Debit_Transaction extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerServices customerServices=new CustomerServices(); 
		
		String ID=req.getParameter("CustomerID"); 
		int id=Integer.parseInt(ID); 
		String AMOUNT=req.getParameter("withdrawAmount");
		double amount=Double.parseDouble(AMOUNT); 
		
		
		
		Customer c_debit=customerServices.debitAmount(id, amount);
		if(c_debit!=null) {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body><h1>"+"Amount " + amount +" debited from your account. Avl Bal Rs: "+c_debit.getBalance()+"</h1></body></html>");
	
		}else 
		if(c_debit.getBalance()<amount){
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body><h1>"+"Insufficient Balance!!"+"</h1></body></html>");
		}
	}
}
