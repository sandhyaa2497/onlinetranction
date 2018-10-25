package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.Userdetails;

@Repository("userDao")
public interface Userdao {
	public void adduser(Userdetails ud);
	
	 
    public List<Userdetails> getAllUserdetatils();
 
    public void deleteuser(String email);
 
   
 
    public Userdetails getuser(String email);


	public void insertUser(Userdetails user);

}

