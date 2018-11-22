package com.niit.dao;

import java.util.List;

import com.niit.model.Categorydetails;


 
public interface Categorydao {

 
    public void addcategory(Categorydetails category);
    
    public void updateCategory(Categorydetails category);
	 
 
    public List<Categorydetails> getAllCategorydetails(); 
 
    public void deletecategory(int cid);
 
    
 
    public Categorydetails getcategory(int cid);

}
