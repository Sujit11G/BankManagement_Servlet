package com.jsp.services;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dao.CustomerDao;
import com.jsp.dao.ManagerDao;
import com.jsp.dto.Customer;
import com.jsp.dto.Manager;

public class ManagerServices {

EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sujit");
	
	EntityManager entityManager =entityManagerFactory.createEntityManager();
	
	EntityTransaction entityTransaction= entityManager.getTransaction();
	
	Random random=new Random();
	ManagerDao managerDao=new ManagerDao();
	CustomerDao customerDao=new CustomerDao();
	Manager manager=new Manager();
	Customer customer=new Customer();
	
	
	//=======================toSave Manager Details=====================
	
	public Manager saveManagerDetails(Manager manager) {
		
		return managerDao.saveManager(manager);
	}
	
	//========================toFetch Manager Details===================
	
	public Manager fetchManagerDetails(int id) {
		
		return managerDao.fetchManagerByID(id);
	}
	
	//============================toFetch All Customer Details============================
	
	public List<Customer> fetchAllCustomerDetails() {
		
		return managerDao.getAllCustomerData();
	}
	
	//================================toUpdate_Manager_Data=========================
	
	public Manager updateManagerData(int id,String email,String password) {
		
		Manager manager=managerDao.fetchManagerByID(id);
		manager.setPassword(password);
		manager.setEmail(email);
		return managerDao.updateManagerDetailsByID(manager, id);
	}
	

	
	//===========================toFetch_AllCustomer_Data==================================
			//=========================By_Managers_ID=================================
	

	public List<Customer> fetchAllCustomer(){
		
		return managerDao.getAllCustomerData();
	}
	        
// ========================toSet_Customer_Data_By_ManagerID==============================
	
	public Customer setCustomerDetails(int managerId, int customerId,String acc_type,String status) {
	
		Manager manager=entityManager.find(Manager.class, managerId);
		
		Customer customer=entityManager.find(Customer.class, customerId);
		
		int acc_no=1000000000 + random.nextInt(900000000);
		customer.setAcc_no(acc_no);
		String ifsc ="SCWT5530";
		customer.setIfsc(ifsc);
		customer.setStatus("Approve");
		customer.setAcc_type(acc_type);
		customer.setManager(manager);
		return customer;
				
	}
	
	
	
}
