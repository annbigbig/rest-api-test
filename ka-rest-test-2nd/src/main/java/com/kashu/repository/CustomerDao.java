package com.kashu.repository;

import java.util.List;
import com.kashu.entity.Customer;

public interface CustomerDao {
	Customer findById(long id);
	
	Customer findByName(String name);
	
	void save(Customer customer);
	
	void update(Customer customer);
	
	void deleteById(long id);

	List<Customer> findAll();
	
	void deleteAll();
	
	boolean isExisted(Customer customer);

}
