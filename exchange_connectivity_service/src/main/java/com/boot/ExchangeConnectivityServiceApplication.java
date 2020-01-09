package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class ExchangeConnectivityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeConnectivityServiceApplication.class, args);
	}

}
