package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Productdetails;
import com.niit.model.Supplierdetails;
import com.niit.model.Userdetails;

@Repository
public class Supplierdaoimpl implements Supplierdao {
	@Autowired
    private SessionFactory sessionFactory;
 
    public void addsupplier(Supplierdetails sd) {
        sessionFactory.getCurrentSession().saveOrUpdate(sd);
 
    }
 
    
 
    public void deletesupplier(int supid) {
    	Supplierdetails supplier = (Supplierdetails) sessionFactory.getCurrentSession().load(
    			Supplierdetails.class, supid);
        if (null != supplier) {
            this.sessionFactory.getCurrentSession().delete(supplier);
        }
 
    }
 
    public Supplierdetails getsupplier(int supid) {
        return (Supplierdetails) sessionFactory.getCurrentSession().get(
        		Supplierdetails.class, supid);
    }
    @Override
	public List<Supplierdetails> getAllSupplierdetails() {
		 return sessionFactory.getCurrentSession().createQuery("from Supplierdetails").list();
	}

}