package com.kashu.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;
import com.kashu.entity.Customer;

@Repository("customerDaoDummy")
public class CustomerDaoDummyImpl implements CustomerDao{
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Customer> customers;
	
	static{
		customers= populateDummyCustomers();
	}

	public Customer findById(long id) {
		for(Customer customer : customers){
			if(customer.getId() == id){
				return customer;
			}
		}
		return null;
	}

	public Customer findByName(String name) {
		for(Customer customer : customers){
			if(customer.getName().equalsIgnoreCase(name)){
				return customer;
			}
		}
		return null;
	}

	public void save(Customer customer) {
		customer.setId(counter.incrementAndGet());
		customers.add(customer);
	}

	public void update(Customer customer) {
		int index = customers.indexOf(customer);
		customers.set(index, customer);
		
	}

	public void deleteById(long id) {
		for (Iterator<Customer> iterator = customers.iterator(); iterator.hasNext(); ) {
		    Customer customer = iterator.next();
		    if (customer.getId() == id) {
		        iterator.remove();
		    }
		}
		
	}

	public List<Customer> findAll() {
		return customers;
	}

	public void deleteAll() {
		customers.clear();
		
	}

	public boolean isExisted(Customer customer) {
		return findByName(customer.getName())!=null;
	}

	private static List<Customer> populateDummyCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(counter.incrementAndGet(),"naruto","naruto@yahoo.com",new GregorianCalendar(1989, Calendar.DECEMBER, 23).getTime()));
		customers.add(new Customer(counter.incrementAndGet(),"sasuke","sasuke@google.com",new GregorianCalendar(1988, Calendar.FEBRUARY, 17).getTime()));
		customers.add(new Customer(counter.incrementAndGet(),"sakura","sakura@pchome.com.tw",new GregorianCalendar(1990, Calendar.JULY, 8).getTime()));
		customers.add(new Customer(counter.incrementAndGet(),"lee","lee@bbc.com",new GregorianCalendar(1991, Calendar.NOVEMBER, 11).getTime()));
		return customers;
	}
}
