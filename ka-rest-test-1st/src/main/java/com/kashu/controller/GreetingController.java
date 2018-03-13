package com.kashu.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kashu.entity.Greet;

@RestController
public class GreetingController{
	@Autowired
	DataSource datasource;
	
	@RequestMapping("/")
	Greet greet(){
		return new Greet("Hello World!");
	}
}
