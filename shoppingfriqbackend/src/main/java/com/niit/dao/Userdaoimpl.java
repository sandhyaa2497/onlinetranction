package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Supplierdetails;
import com.niit.model.Userdetails;

@Repository 
public class Userdaoimpl implements Userdao {
	@Autowired
    private SessionFactory sessionFactory;
 
    public void adduser(Userdetails ud) {
        sessionFactory.getCurrentSession().saveOrUpdate(ud);
 
    }
 
   
    
 
    public void deleteuser(int userid) {
    	Userdetails user = (Userdetails) sessionFactory.getCurrentSession().load(
    			Userdetails.class, userid);
        if (null != user) {
            this.sessionFactory.getCurrentSession().delete(user);
        }
 
    }
 
    public Userdetails getuser(int userid) {
        return (Userdetails) sessionFactory.getCurrentSession().get(
        		Userdetails.class, userid);
    }

	@Override
	public List<Userdetails> getAllUserdetatils() {
		 return sessionFactory.getCurrentSession().createQuery("from Userdetails").list();
	}

	
}
