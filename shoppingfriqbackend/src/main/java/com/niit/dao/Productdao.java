package com.niit.dao;
import java.util.List;

import com.niit.model.Productdetails;

public interface Productdao {
	public void addproduct(Productdetails prod);
	 
    public List<Productdetails> getAllProductdetails();
 
    public void deleteproduct(Integer Productdetails);
 
    public Productdetails updateproduct(Productdetails prod);
 
    public Productdetails getproduct(int proid);

}
