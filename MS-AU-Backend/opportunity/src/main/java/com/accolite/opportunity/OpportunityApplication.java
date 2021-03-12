package com.accolite.opportunity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpportunityApplication {
	private static final Logger logger = LoggerFactory.getLogger(OpportunityApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(OpportunityApplication.class, args);
	}

}
