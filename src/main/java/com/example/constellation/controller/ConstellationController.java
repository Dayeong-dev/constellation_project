package com.example.constellation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConstellationController {
	
	@GetMapping("/")
	public String root() {
		System.out.println("root......");
		
		return "index";
	}
}
