package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.ExchangeConnectivityService;

@RestController
public class ExchangeConnectivityController {

	
	@Autowired
	ExchangeConnectivityService exchangeConnectivityService;
	
	@RequestMapping(method = RequestMethod.GET,value = "/exchange/execute")
	public String execute() {
		return exchangeConnectivityService.executeOnExchange();
	}
	
}
