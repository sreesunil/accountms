package com.tekarch.accountms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tekarch.accountms")
public class AccountmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountmsApplication.class, args);
	}

}
