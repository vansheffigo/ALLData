package com.example.debitcreditproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.debitcreditproject.entity", "com.example.debitcreditproject.repository",
		"com.example.debitcreditproject.controller", "com.example.debitcreditproject.service",
		"com.example.debitcreditproject.dto" })
public class DebitcreditprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebitcreditprojectApplication.class, args);
	}

}
