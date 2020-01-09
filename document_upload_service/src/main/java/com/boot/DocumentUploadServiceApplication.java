package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class DocumentUploadServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentUploadServiceApplication.class, args);
	}

}
