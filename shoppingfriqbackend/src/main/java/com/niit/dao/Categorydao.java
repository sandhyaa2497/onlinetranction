package com.niit.dao;

import java.util.List;

import com.niit.model.Categorydetails;

 
public interface Categorydao {

 
    public void addcategory(Categorydetails cd);
 
    public List<Categorydetails> getAllcategorydetails();
 
    public void deletecategory(Integer categorydetails);
 
    public Categorydetails updatecategory(Categorydetails cd);
 
    public Categorydetails getcategory(int cid);

}
