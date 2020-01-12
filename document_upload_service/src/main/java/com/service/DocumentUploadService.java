package com.service;

import org.springframework.stereotype.Service;

@Service
public class DocumentUploadService {

	public void uploadDocument() {
		try { Thread.sleep(4000);} 
		catch (InterruptedException e) {e.printStackTrace();}
	}
	
	public String getReportStatusFromDB() {
		throw new RuntimeException("Database Contention Timeout");
	}
}
