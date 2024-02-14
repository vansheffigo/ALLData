package com.learningportal.LearningPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.learningportal.LearningPortal.service.impl",
		"com.learningportal.LearningPortal.controller", "com.learningportal.LearningPortal.repository",
		"com.learningportal.LearningPortal.service.CourseService", "com.learningportal.LearningPortal.dto.Mapper",
		"com.learningportal.LearningPortal.dto.Mapper.CourseMapper",
		"com.learningportal.LearningPortal.service.FavoriteService" })

public class LearningPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningPortalApplication.class, args);
	}

}
