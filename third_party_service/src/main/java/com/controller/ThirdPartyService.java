package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdPartyService {
	
	@RequestMapping(method=RequestMethod.GET,value="/thirdparty/process")
	public void processInfo() {
		try {Thread.sleep(1000);
		} catch (InterruptedException e) {}
	}

}
