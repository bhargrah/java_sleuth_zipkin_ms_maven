package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreasuryApprovalConrtroller {
	
	@RequestMapping(method=RequestMethod.GET,value = "/treasury/checkfunds")
	public String checkFundsStatus() {
		// call code for exchange connectivity
		return "funded";
	}

}
