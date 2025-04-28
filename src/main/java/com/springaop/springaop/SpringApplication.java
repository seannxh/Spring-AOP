package com.springaop.springaop;

import com.springaop.springaop.business.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplication implements CommandLineRunner {

	private BusinessService service1;

	public SpringApplication(BusinessService service1) {
		this.service1 = service1;
	}

	private Logger logger = LoggerFactory.getLogger(getClass());
	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Value Returned is {}",service1.calculateMax());
	}
}
