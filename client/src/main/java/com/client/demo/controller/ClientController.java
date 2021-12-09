package com.client.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/")
public class ClientController {

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	private EurekaClient client;
	
	@GetMapping("/")
	public String callService() {

		RestTemplate restTemplate = restTemplateBuilder.build();
		InstanceInfo instanceInfo = client.getNextServerFromEureka("service", false);
		String baseURL = instanceInfo.getHomePageUrl();
		ResponseEntity<String> response =
				restTemplate.exchange(baseURL, HttpMethod.GET, null, String.class);
	
		return response.getBody();
	
		
	}
	
	@GetMapping("/service1")
	public String callService1() {
		RestTemplate restTemplete1 = restTemplateBuilder.build();
		InstanceInfo instanceInfo = client.getNextServerFromEureka("service1", false);
		String baseURL = instanceInfo.getHomePageUrl();
		ResponseEntity<String> response =
					restTemplete1.exchange(baseURL, HttpMethod.GET, null, String.class);

		return response.getBody();
		
		
	}
}
