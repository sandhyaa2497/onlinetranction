package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Categorydetails;
import com.niit.model.Productdetails;

@Repository
@Transactional
public class Productdaoimpl implements Productdao{
	@Autowired
    private SessionFactory sessionFactory;
 
    public void addproduct(Productdetails prod) {
        sessionFactory.getCurrentSession().saveOrUpdate(prod);
 
    }
 
    public void updateProduct(Productdetails product) {
		Session session=sessionFactory.getCurrentSession();
		session.update(product);
	}
    
    public void deleteproduct(int prodid) {
    	Productdetails product = (Productdetails) sessionFactory.getCurrentSession().load(
    			Productdetails.class, prodid);
        if (null != product) {
            this.sessionFactory.getCurrentSession().delete(product);
        }
 
    }
 
    public Productdetails getproduct(int prodid) {
        return (Productdetails) sessionFactory.getCurrentSession().get(
        		Productdetails.class, prodid);
    }
    @SuppressWarnings("unchecked")
	@Override
    public List<Productdetails> getAllProductdetails() {
    	 
        return sessionFactory.getCurrentSession().createQuery("from Productdetails").list();
    }



    @SuppressWarnings("unchecked")
   	@Override
       public List<Categorydetails> getAllCategorydetails() {
       	 
           return sessionFactory.getCurrentSession().createQuery("from Categorydetails").list();
       }

}
