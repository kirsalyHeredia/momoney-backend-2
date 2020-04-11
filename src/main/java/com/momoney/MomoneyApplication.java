package com.momoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.momoney.models"})
public class MomoneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MomoneyApplication.class, args);
	}

}
