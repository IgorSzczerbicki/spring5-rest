package com.nauka.spring5.restControllerDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestTestController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
}