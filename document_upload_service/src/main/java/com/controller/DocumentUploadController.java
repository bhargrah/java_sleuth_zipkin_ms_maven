package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.DocumentUploadService;

@RestController
public class DocumentUploadController {
	
	@Autowired
	DocumentUploadService documentUploadService;
	
	@Value("${spring.application.name}")
	String applicationName;
	
	@RequestMapping("/")
    public String index() {
        return applicationName;
    }
	
	@RequestMapping(method=RequestMethod.GET,value="/documentservice/upload")
	public String uploadDocument() {
		documentUploadService.uploadDocument();
		return "document_uploaded";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/documentservice/reportgeneration")
	public String reportGeneration() {
		documentUploadService.getReportStatusFromDB();
		return "repeort_generated";
	}

}
