package com.service;

import org.springframework.stereotype.Service;

@Service
public class ThirdPartyService {
	
	public void process() {
		try {Thread.sleep(2000);
		} catch (InterruptedException e) {}
	}

	public String status() {
		try {Thread.sleep(5000);
		} catch (InterruptedException e) {}
		return "ok_otc";
	}
}
