package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Admin;
import com.jsp.dto.Manager;


public class AdminDao {

EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sujit");
	
	EntityManager entityManager =entityManagerFactory.createEntityManager();
	
	EntityTransaction entityTransaction= entityManager.getTransaction();
	
	//==============================toSave_Admin_Details====================
	
		public Admin saveAdmin(Admin admin) {
			
			entityTransaction.begin();
			entityManager.persist(admin);
			entityTransaction.commit();
			
			return admin;
		}
		
	//==============================toFetching All Manager Details===============================
		
			public List<Manager>  getAllManagerDetails(){
				
				String jpql="SELECT m FROM Manager m";
				
				Query query=entityManager.createQuery(jpql);
				
				List<Manager> managers=query.getResultList();
				
				return managers;
			}
	//=============================toGet_Admin_By_ID========================================
			
			public Admin getAdminByID(Admin admin,int id) {
				
				return entityManager.find(Admin.class, id);
			}
}
