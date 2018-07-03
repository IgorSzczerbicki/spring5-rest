package com.nauka.spring5.rest.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "apiIndex";
	}
	
	/*@GetMapping("/api")
	public String gethome() {
		return "apiIndex";
	}
	
	@GetMapping("/systems")
	public String systems() {
		return "systems";
	}
	
	@GetMapping("/leaders")
	public String leaders() {
		return "leaders";
	}*/
}