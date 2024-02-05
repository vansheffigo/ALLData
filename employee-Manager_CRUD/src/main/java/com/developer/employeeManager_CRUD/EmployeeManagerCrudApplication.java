package com.developer.employeeManager_CRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import controller.EmployeeController;
import service.impl.EmployeeServiceImpl;

@SpringBootApplication
@ComponentScan(basePackageClasses = { EmployeeController.class, EmployeeServiceImpl.class })
@EnableJpaRepositories(basePackages = { "repository" })
public class EmployeeManagerCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagerCrudApplication.class, args);
	}

}
