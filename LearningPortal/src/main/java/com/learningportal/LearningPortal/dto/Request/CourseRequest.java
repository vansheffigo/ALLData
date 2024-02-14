package com.learningportal.LearningPortal.dto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseRequest {
	@JsonProperty("course_name")
	private String title;

	@JsonProperty("course_id")
	private Long courseId;

	@JsonProperty("email")
	private String email;
	// private String authorUsername;
}
