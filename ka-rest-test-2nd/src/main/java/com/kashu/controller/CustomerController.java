package com.kashu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kashu.entity.Customer;
import com.kashu.repository.CustomerDao;
import com.kashu.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	@Qualifier("customerDaoJdbc") //change to customerDaoJdbc if u need
	CustomerDao customerDao;
	
	// -------------------Retrieve All Users---------------------------------------------

	@RequestMapping(value = "/customer/", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> listAllCustomers() {
		List<Customer> customers = customerDao.findAll();
		if (customers.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	// -------------------Retrieve Single User------------------------------------------

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomer(@PathVariable("id") long id) {
		logger.info("Fetching Customer with id {}", id);
		Customer customer = customerDao.findById(id);
		if (customer == null) {
			logger.error("Customer with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Customer with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	
}
