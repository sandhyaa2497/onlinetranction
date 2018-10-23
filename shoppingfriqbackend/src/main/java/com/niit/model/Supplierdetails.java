package com.niit.model;

import javax.persistence.Entity;

@Entity 
public class Supplierdetails {
	private int supid;
	private String supname;
	public int getSupid() {
		return supid;
	}
	public void setSupid(int supid) {
		this.supid = supid;
	}
	public String getSupname() {
		return supname;
	}
	public void setSupname(String supname) {
		this.supname = supname;
	}
}
