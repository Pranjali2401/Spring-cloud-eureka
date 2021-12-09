package com.server.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ClientController {

	@Value("${service.instance.name}")
	private String instance;
	
	@GetMapping("/")
	public String message() {
		return "Hello from "+instance;
	}
	
}
