package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Supplierdetails;
import com.niit.model.Userdetails;

@Repository("userDao")
@Transactional
public class Userdaoimpl implements Userdao {
	@Autowired
    private SessionFactory sessionFactory;
 
    public void adduser(Userdetails ud) {
        sessionFactory.getCurrentSession().saveOrUpdate(ud);
 
    }
 
   
    
 
    public void deleteuser(String email) {
    	Userdetails user = (Userdetails) sessionFactory.getCurrentSession().load(
    			Userdetails.class, email);
        if (null != user) {
            this.sessionFactory.getCurrentSession().delete(user);
        }
 
    }
 
    public Userdetails getuser(String email) {
        return (Userdetails) sessionFactory.getCurrentSession().get(
        		Userdetails.class, email);
    }

	@Override
	public List<Userdetails> getAllUserdetatils() {
		 return sessionFactory.getCurrentSession().createQuery("from Userdetails").list();
	}




	@Override
	public void insertUser(Userdetails user) {
		// TODO Auto-generated method stub
		
	}

	
}
