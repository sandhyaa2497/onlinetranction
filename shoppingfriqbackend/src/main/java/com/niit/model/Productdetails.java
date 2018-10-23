package com.niit.model;

import javax.persistence.Entity;

@Entity 
public class Productdetails {
	private int prodid;
	   private String prodname;
	   private int prize;
	   private String prodetails;
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	public String getProdetails() {
		return prodetails;
	}
	public void setProdetails(String prodetails) {
		this.prodetails = prodetails;
	}

}
