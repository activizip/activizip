package com.activizip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ActivizipApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivizipApplication.class, args);
	}

}
