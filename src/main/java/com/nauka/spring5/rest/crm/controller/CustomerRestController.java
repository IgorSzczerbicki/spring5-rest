package com.nauka.spring5.rest.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nauka.spring5.rest.crm.domain.Customer;
import com.nauka.spring5.rest.crm.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
}