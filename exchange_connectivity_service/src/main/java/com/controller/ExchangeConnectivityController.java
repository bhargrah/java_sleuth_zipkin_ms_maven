package com.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeConnectivityController {

	public static Random random = new Random(10);
	
	
	@RequestMapping(method = RequestMethod.GET,value = "/exchange/execute")
	public String executeOnExchange() {
		try { Thread.sleep(random.nextInt()*0000);
		} catch (InterruptedException e) { e.printStackTrace();}
		return "executed_on_exchange";
	}
	
}
