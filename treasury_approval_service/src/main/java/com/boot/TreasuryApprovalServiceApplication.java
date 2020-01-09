package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.*")
public class TreasuryApprovalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreasuryApprovalServiceApplication.class, args);
	}

}
