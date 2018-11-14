package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Categorydetails;


@Repository
@Transactional
public class Categorydaoimpl implements Categorydao {
	@Autowired
    private SessionFactory sessionFactory;
 
    public void addcategory(Categorydetails category) {
        sessionFactory.getCurrentSession().saveOrUpdate(category);
 
    }
    public void updateCategory(Categorydetails category) {
		Session session=sessionFactory.getCurrentSession();
		session.update(category);
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
    @SuppressWarnings("unchecked")
	@Override
    public List<Categorydetails> getAllCategorydetails() {
    	 
        return sessionFactory.getCurrentSession().createQuery("from Categorydetails").list();
    }
	
}
