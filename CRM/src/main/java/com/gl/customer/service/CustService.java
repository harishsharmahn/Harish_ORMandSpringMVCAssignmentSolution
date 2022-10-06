package com.gl.customer.service;

import java.util.List;
import com.gl.customer.entity.CustDetail;


public interface CustService {
	public List<CustDetail> findAll();

	public CustDetail findById(int theId);

	public void save(CustDetail theCustDetail);

	public void deleteById(int theId);

	public List<CustDetail> searchBy(String fname, String lname,String email);

}
