package com.niit.dao;

import java.util.List;

import com.niit.model.Userdetails;

public interface Userdao {
	public void adduser(Userdetails ud);
	
	 
    public List<Userdetails> getAllUserdetatils();
 
    public void deleteuser(int Userid);
 
   
 
    public Userdetails getuser(int userid);


}

