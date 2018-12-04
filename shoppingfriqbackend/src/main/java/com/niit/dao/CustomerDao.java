package com.niit.dao;



import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.niit.model.Customer;
import com.niit.model.Userdetails;



@Repository("customerDao")
public interface CustomerDao {
	
	 void registerCustomer(Customer customer);
		
	
	boolean isEmailUnique(String email);


	 void updateCustomer(Customer customer);

	Userdetails getUser(String email);



	

}

