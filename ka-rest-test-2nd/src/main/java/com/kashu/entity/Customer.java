package com.kashu.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Customer {
	private long id;
	private String name;
	private String email;
	private Date created_date;
	
	public Customer() {
		
	}
	
	public Customer(long id, String name, String email, Date created_date) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.created_date = created_date;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//@JsonIgnore
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	
	
}
