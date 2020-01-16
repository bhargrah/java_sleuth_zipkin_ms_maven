package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brave.Span;
import brave.Tracer;

@Service
public class BookingService {
	
	@Autowired
	private Tracer dbTraces;
	
	public String initiateBooking() {
		return "sample initiate Booking done";	
	}

	
	public String lookupBookingFromDB() {
		
		Span database = this.dbTraces.currentSpan();
		database.name("DB Call Simulation (lookupBookingFromDB)");
		database.start();
				
		try {Thread.sleep(8000);
		} catch (InterruptedException e) {}
		
		database.finish();
		return "found_in_DB";	
	}
}
