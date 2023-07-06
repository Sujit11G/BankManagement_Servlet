package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Customer;

public class CustomerDao {

    EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sujit");
	
	EntityManager entityManager =entityManagerFactory.createEntityManager();
	
	EntityTransaction entityTransaction= entityManager.getTransaction();
	
	Customer customer=new Customer();
	
	//==============================toSave_Customer_Details======================
	
	public Customer saveCustomer(Customer customer) {
		
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		
		return customer;
	}
	
	//=============================toFetch_Customer_Details=====================
	
		public Customer fetchCustomerByID(int id) {
			
			return entityManager.find(Customer.class, id);
		}
		
	
		
	//===========================toDelete_Customer_Details========================
		
		public boolean deleteCustomerDetails(int id) {
			
			Customer customer=entityManager.find(Customer.class, id);
			
			entityTransaction.begin();
			entityManager.remove(customer);
			entityTransaction.commit();
			
			return true;	
		}
		
	//=============================toUpdate_Customer_Details=========================
		
		public Customer updateCustomerDetails(Customer customer,int id) {
			Customer c=entityManager.find(Customer.class, id);
			if(c!=null) {
				entityTransaction.begin();
				entityManager.persist(customer);
				entityTransaction.commit();	
			}
			return customer;
			
		}	
    //=============================toUpdate_Customer_Details=========================
		
				public Customer updateCustomer(Customer customer) {
				 
					if(customer!=null) {
						entityTransaction.begin();
						entityManager.merge(customer);
						entityTransaction.commit();	
					}
					return customer;
					
				}
}
