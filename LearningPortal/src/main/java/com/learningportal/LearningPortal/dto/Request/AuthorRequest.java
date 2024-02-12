package com.learningportal.LearningPortal.dto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AuthorRequest {
	@JsonProperty("name")
	private String name;
	@JsonProperty("course")
	private String course;

}
