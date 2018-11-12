package com.niit.dao;
import java.util.List;

import com.niit.model.Categorydetails;
import com.niit.model.Productdetails;

public interface Productdao {
	public void addproduct(Productdetails prod);
	
	public void updateProduct(Productdetails product);
	 
    public List<Productdetails> getAllProductdetails();
 
    public void deleteproduct(int Prodid);
 
    public Productdetails getproduct(int proid);

	public List<Categorydetails> getAllCategorydetails();

}
