package com.niit.dao;

import java.util.List;


import com.niit.model.Supplierdetails;


public interface Supplierdao {
	public void addsupplier(Supplierdetails sd);
	
	public void updatesupplier(Supplierdetails supplier);
	 
    public List<Supplierdetails> getAllSupplierdetails();
 
    public void deletesupplier(int Supid);
 
   
 
    public Supplierdetails getsupplier(int supid);

}
