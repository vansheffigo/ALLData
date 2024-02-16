package com.example.portal.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseRequest {
	@JsonProperty("course_name")
	private String courseTitle;

	@JsonProperty("course_id")
	private Long courseId;

	@JsonProperty("category_name")
	private String categoryName;

	@JsonProperty("email")
	private String email;

}
