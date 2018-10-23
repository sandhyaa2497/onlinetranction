package com.niit.dao;

import java.util.List;

import com.niit.model.Supplierdetails;


public interface Supplierdao {
	public void addsupplier(Supplierdetails sd);
	 
    public List<Supplierdetails> getAllSupplierdetails();
 
    public void deletesupplier(Integer Supplierdetails);
 
    public Supplierdetails updatesupplier(Supplierdetails sd);
 
    public Supplierdetails getsupplier(int supid);

}
