package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.CartItem;
import com.niit.model.CustomerOrder;
@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao{
	@Autowired
	private SessionFactory sessionFactory;
	


	
	public List<CustomerOrder> getCustomerOrder(String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from CustomerOrder where user.email=?");
		query.setString(0, email);
		return query.list();	
	}
	
	
	
}
