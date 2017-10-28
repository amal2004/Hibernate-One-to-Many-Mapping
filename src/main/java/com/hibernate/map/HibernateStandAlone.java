package com.hibernate.map;

import org.hibernate.Session;

import com.hibernate.map.model.Address;
import com.hibernate.map.model.Student;

public class HibernateStandAlone {
	
	 @SuppressWarnings("unchecked")
	    public static void main(String[] args) {
	 
	       
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	 
	        Address address = new Address("OMR Road", "Chennai", "TN", "600097");
			//By using cascade=all option the address need not be saved explicitly when the student object is persisted the address will be automatically saved.
            //session.save(address);
	        
	        Student student1 = new Student("Eswar", address);
			Student student2 = new Student("Joe", address);
			session.save(student1);
			session.save(student2);
	         
	        session.getTransaction().commit();
	        session.close();  
	    }

}
