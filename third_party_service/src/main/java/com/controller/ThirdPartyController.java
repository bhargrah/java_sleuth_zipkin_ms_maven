package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.ThirdPartyService;

@RestController
public class ThirdPartyController {
	
	@Autowired
	ThirdPartyService thirdPartyService;
	
	@Value("${spring.application.name}")
	String applicationName;
	
	@RequestMapping("/")
    public String index() {
        return applicationName;
    }
	
	@RequestMapping(method=RequestMethod.GET,value="/thirdparty/process")
	public String process() {
		thirdPartyService.process();
		return "executed_with_thirdparty";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/thirdparty/status")
	public String status() {
		return thirdPartyService.status();
	}

}
