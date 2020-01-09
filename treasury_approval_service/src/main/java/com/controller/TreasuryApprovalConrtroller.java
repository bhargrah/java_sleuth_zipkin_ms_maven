package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TreasuryApprovalConrtroller {
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method=RequestMethod.GET,value = "/treasury/checkfunds")
	public String checkFundsStatus() {
		
		String status= "funded";
		// call code for exchange connectivity
		
		ResponseEntity<String> exchangeStatus = restTemplate.getForEntity("http://localhost:9353/exchange/execute",String.class);
		status = status + "-" + exchangeStatus.getBody().toString();
		
		return status;
	}

}
