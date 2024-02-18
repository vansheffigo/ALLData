package com.example.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.portal.service.impl", "com.example.portal.controller",
		"com.example.portal.repository", "com.example.portal.service.CourseService", "com.example.portal.dto.Mapper",
		"com.example.portal.dto.Mapper.CourseMapper", "com.example.portal.service.FavoriteService",
		"com.example.portal.repository.AdminRepository" })

public class PortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
	}

}
