package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.service.TreasuryApprovalService;

@RestController
public class TreasuryApprovalConrtroller {
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	TreasuryApprovalService treasuryApprovalService;
	
	@Value("${spring.application.name}")
	String applicationName;
	
	@RequestMapping("/")
    public String index() {
        return applicationName;
    }
	
	@RequestMapping(method=RequestMethod.GET,value = "/treasury/checkfundstatus")
	public String checkFundsStatus() {
		
		String status= treasuryApprovalService.fundInternally();
		
		ResponseEntity<String> exchangeStatus = restTemplate.getForEntity("http://localhost:9353/exchange/execute",String.class);
		status = status + "-" + exchangeStatus.getBody().toString();
				
		return status;
	}
	
	@RequestMapping(method=RequestMethod.GET,value = "/treasury/report")
	public String reportGeneration() {	
		return "treasury_report";
	}
	
	@RequestMapping(method=RequestMethod.GET,value = "/treasury/checkexternalfunds")
	public String checkExternalFunds() {
		
		String status= treasuryApprovalService.fundExternally();
		
		ResponseEntity<String> exchangeStatus = restTemplate.getForEntity("http://localhost:9353/exchange/execute",String.class);
		status = status + "-" + exchangeStatus.getBody().toString();
		
		ResponseEntity<String> thirdpartyStatus = restTemplate.getForEntity("http://localhost:9355/thirdparty/process",String.class);
		status = status + "-" + thirdpartyStatus.getBody().toString();
		
		return status;
	}

}
