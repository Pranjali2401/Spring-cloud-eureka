package com.client.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Service1Controller {

	@Value("${service.instance.name}")
	private String instance;
	
	@GetMapping("/")
	public String message() {
		return "Hello From service 1 "+instance;
	}
}
