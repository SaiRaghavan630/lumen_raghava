package com.example.demo.controllers;

import javax.annotation.security.RolesAllowed;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
@RestController
@RequestMapping(path="/api/v1")
public class BookController {
	
	@Value("${server.port}")
	private String port;
	
	//Admin User only will be able to access this endpoint
	@GetMapping(path="/books")
	public String[] getBestBooks() {
		return new String[] {"HeadFirstJava","Thinking in Java","Effective Java",port};
		
	}
	
}

