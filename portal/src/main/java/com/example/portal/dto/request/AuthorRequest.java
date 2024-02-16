package com.example.portal.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AuthorRequest {
	@JsonProperty("name")
	private String authorName;
	@JsonProperty("course")
	private String authorCourse;

}
