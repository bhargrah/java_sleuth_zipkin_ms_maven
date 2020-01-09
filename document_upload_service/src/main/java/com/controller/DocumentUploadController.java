package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.DocumentUploadService;

@RestController
public class DocumentUploadController {
	
	@Autowired
	DocumentUploadService documentUploadService;
	
	@RequestMapping(method=RequestMethod.GET,value="/documentservice/upload")
	public String uploadDocument() {
		documentUploadService.uploadDocument();
		return "document_uploaded";
	}

}
