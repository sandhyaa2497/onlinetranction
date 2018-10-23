package com.niit.model;

import javax.persistence.Entity;

@Entity 
public class Categorydetails {
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	private int cid;
private String categoryname;




}
