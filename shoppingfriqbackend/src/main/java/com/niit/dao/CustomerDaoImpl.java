package com.niit.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Authorities;
import com.niit.model.Customer;
import com.niit.model.Userdetails;

@Repository("customerDao")
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;
		public void registerCustomer(Customer customer) {
		Session session=sessionFactory.getCurrentSession();
		
		Userdetails user=customer.getUser();
		Authorities authorities=user.getAuthorities();
		authorities.setUser(user);
		
		session.save(customer);

		}
		public boolean isEmailUnique(String email) {
			Session session=sessionFactory.getCurrentSession();
			Userdetails user=(Userdetails)session.get(Userdetails.class, email);
			if(user==null)
				return true;
			else 
				return false;
		}
		@Override
		public Userdetails getUser(String email) {
			Session session=sessionFactory.getCurrentSession();
			Userdetails user=session.get(Userdetails.class,email);
			return user;
			
		}
		

	}