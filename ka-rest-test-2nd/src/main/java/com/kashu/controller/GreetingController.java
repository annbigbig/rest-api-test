package com.kashu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kashu.entity.Greet;

@RestController
public class GreetingController{
	
	@RequestMapping("/")
	Greet greet(){
		return new Greet("Hello World!");
	}
}
