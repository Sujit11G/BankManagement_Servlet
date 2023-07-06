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

@WebServlet("/transfer_Amount")
public class TransferAmount extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Customer customer=new Customer();
		CustomerServices customerServices=new CustomerServices(); 
		
		String senderID=req.getParameter("CustomerID"); 
		int sender_id=Integer.parseInt(senderID); 
		
		String reciverID=req.getParameter("transferId"); 
		int reciver_id=Integer.parseInt(reciverID);
		
		String AMOUNT=req.getParameter("transferAmount");
		double amount=Double.parseDouble(AMOUNT);
		
		Customer c_transfer=customerServices.transferMoney(sender_id, reciver_id, amount);
		Customer sender = customerServices.getCustomerByID(sender_id);
		
		if(c_transfer!=null&&sender!=null) {
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><body><h1>"+"Amount " + amount +" successfully transferd to " +c_transfer.getName()+". Avl Bal Rs: "+sender.getBalance()+"</h1></body></html>");
	
		}
		
	}
}
