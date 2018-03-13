package com.kashu.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kashu.entity.Customer;
import com.kashu.util.CustomerMapper;

@Repository("customerDaoJdbc")
public class CustomerDaoJdbcImpl implements CustomerDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public Customer findById(long id) {
		String sql = "SELECT * FROM CUSTOMER WHERE ID = ?";
		Customer customer = jdbcTemplate.queryForObject(sql, new Object[] {id}, new CustomerMapper());
		return customer;
	}

	public Customer findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

	public List<Customer> findAll() {
		List<Customer> customers = jdbcTemplate.query("SELECT * FROM CUSTOMER", new CustomerMapper());
		return customers;
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public boolean isExisted(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

}
