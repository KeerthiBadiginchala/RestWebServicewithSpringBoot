package com.kb.restwswithspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/*
 * A Gateway class to initiate SpringBoot application
 * 
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class RestWsWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWsWithSpringBootApplication.class, args);
	}
}
