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

import com.service.BookingService;

@RestController
public class BookingController {
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	BookingService bookingService;
	
	@Value("${spring.application.name}")
	String applicationName;
	
	@RequestMapping("/")
    public String index() {
        return applicationName;
    }
	
	/**
	 * This method will initiate internal booking using no external API
	 */
	@RequestMapping(method = RequestMethod.GET,value = "/booking/initiatebooking")
	public String initiateBooking() {
		String status = "booking-initiated";
		
		// calling treasury service to check for funds
		ResponseEntity<String> fundingStatus = restTemplate.getForEntity("http://localhost:9352/treasury/checkfundstatus",String.class);
		status = status + "-" +fundingStatus.getBody().toString();
		
		if((fundingStatus.getBody().toString()).startsWith("internal_funded")) {	
			// route this request to deal documentation service 
			ResponseEntity<String> dosServiceStatus = restTemplate.getForEntity("http://localhost:9354/documentservice/upload",String.class);
			status = status + "-" + dosServiceStatus.getBody().toString();
		}
		
		return status;
		
	}
	
	/**
	 * This method when called will simulate exception TIMEOUT scenario
	 */
	@RequestMapping(method=RequestMethod.GET,value = "/booking/reportgeneration")
	public String reportGeneration() {
		
		String exceptionStatus = "";
		ResponseEntity<String> treasuryReportStatus = restTemplate.getForEntity("http://localhost:9352/treasury/report",String.class);
		exceptionStatus = exceptionStatus + treasuryReportStatus.toString();
		
		ResponseEntity<String> documentserviceReportStatus = restTemplate.getForEntity("http://localhost:9354/documentservice/reportgeneration",String.class);
		exceptionStatus = exceptionStatus + documentserviceReportStatus.toString();
		
		return exceptionStatus;
	}
	

	/**
	 * This method will simulate booking via third party API
	 */
	@RequestMapping(method=RequestMethod.GET,value = "/booking/delegatebooking")
	public String delegateBooking() {
		
		String exceptionStatus = "";
		ResponseEntity<String> treasuryReportStatus = restTemplate.getForEntity("http://localhost:9352/treasury/checkexternalfunds",String.class);
		exceptionStatus = exceptionStatus + treasuryReportStatus.toString();
		
		ResponseEntity<String> documentserviceReportStatus = restTemplate.getForEntity("http://localhost:9354/documentservice/upload",String.class);
		exceptionStatus = exceptionStatus + documentserviceReportStatus.toString();
		
		//no sleuth
		restTemplate.getForEntity("http://localhost:9355/thirdparty/status",String.class);
		return exceptionStatus;
	}
	
	/**
	 * This method will simulate custome span implementation 
	 */
	@RequestMapping(method=RequestMethod.GET,value = "/booking/custombooking")
	public String customBooking() {
		
		String exceptionStatus = "custom_span";
		
		String dbResult = bookingService.lookupBookingFromDB();
		exceptionStatus = exceptionStatus + dbResult.toString();
		
		ResponseEntity<String> treasuryReportStatus = restTemplate.getForEntity("http://localhost:9352/treasury/checkfundstatus",String.class);
		exceptionStatus = exceptionStatus + treasuryReportStatus.toString();
		
		ResponseEntity<String> documentserviceReportStatus = restTemplate.getForEntity("http://localhost:9354/documentservice/upload",String.class);
		exceptionStatus = exceptionStatus + documentserviceReportStatus.toString();
		
		return exceptionStatus;
	}

}
