package com.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ExchangeConnectivityService {
	
	public static Random random = new Random(10);
	
	public String executeOnExchange() {
		try { Thread.sleep(random.nextInt()*0000);
		} catch (InterruptedException e) { e.printStackTrace();}
		return "executed_on_exchange";
	}

}
