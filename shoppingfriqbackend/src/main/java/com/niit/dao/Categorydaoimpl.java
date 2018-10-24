package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Categorydetails;

@Repository
public class Categorydaoimpl implements Categorydao {
	@Autowired
    private SessionFactory sessionFactory;
 
    public void addcategory(Categorydetails cd) {
        sessionFactory.getCurrentSession().saveOrUpdate(cd);
 
    }
 
    
   
   
    public void deletecategory(int cid) {
        Categorydetails category = (Categorydetails) sessionFactory.getCurrentSession().load(
                Categorydetails.class, cid);
        if (null != category) {
            this.sessionFactory.getCurrentSession().delete(category);
        }
 
    }
 
    public Categorydetails getcategory(int cid) {
        return (Categorydetails) sessionFactory.getCurrentSession().get(
                Categorydetails.class, cid);
    }
    @Override
    public List<Categorydetails> getAllCategorydetails() {
    	 
        return sessionFactory.getCurrentSession().createQuery("from Categorydetails").list();
    }

}
