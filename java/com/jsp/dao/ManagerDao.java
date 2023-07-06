package com.jsp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.jsp.dto.Customer;
import com.jsp.dto.Manager;


public class ManagerDao {

EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sujit");
	
	EntityManager entityManager =entityManagerFactory.createEntityManager();
	
	EntityTransaction entityTransaction= entityManager.getTransaction();
	
	CustomerDao customerDao=new CustomerDao();
	Customer customer = new Customer();
	 Manager manager=new Manager();
	
	
	//==============================toSave Manager Details====================
	
	public Manager saveManager(Manager manager) {
		
		entityTransaction.begin();
		entityManager.persist(manager);
		entityTransaction.commit();
		
		return manager;
	}
	
	//======================================toLogin===================================
	
	public Manager fetchManagerByID(int id) {
		
		return entityManager.find(Manager.class, id);
	}
	
	//===============================toDelete_Manager_Details======================

	public boolean deleteManagerDetails(int id1) {
	
		
		manager=entityManager.find(Manager.class, id1);
		
			entityTransaction.begin();
			entityManager.remove(manager);	
			entityTransaction.commit();
			
			return true;
					
	}
	
	//============================toFetch_All_Customer_Details=====================
	
			public List<Customer> getAllCustomerData(){
				
				String jpql="SELECT c FROM Customer c";
				Query query=entityManager.createQuery(jpql);
				
				List<Customer> customers=query.getResultList();
				
				return customers;			
			}
	
	
	//===============================toUpdate Manager Details=============================
		
		public Manager updateManagerDetailsByID(Manager manager,int id) {
			
			Manager m=entityManager.find(Manager.class, id);
			if(m!=null) {
				entityTransaction.begin();
				entityManager.persist(manager);
				entityTransaction.commit();
				
				return manager;
			}
			return null;
			
		}
	//================================toSet_CustomerID_to_ManagerID======================
		
		public void setCustomerID_to_ManagerID() {
			
			Manager m1=new Manager();
			
			Customer c1=new Customer();
			
			ArrayList<Customer> customers=new ArrayList<Customer>();
			customers.add(c1);
			
			c1.setManager(m1);
			m1.setCustomers(customers);
			
			entityTransaction.begin();
			entityManager.persist(c1);
			entityManager.persist(m1);
			entityTransaction.commit();
		}
		
		//===============================toUpdate Manager Details=============================
		
				public Manager updateManager(Manager manager) {
					
					
					if(manager!=null) {
						entityTransaction.begin();
						entityManager.persist(manager);
						entityTransaction.commit();
					}
						return manager;
					
				}
	
		
}
