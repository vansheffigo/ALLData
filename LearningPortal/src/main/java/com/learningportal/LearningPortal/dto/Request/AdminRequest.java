package com.learningportal.LearningPortal.dto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AdminRequest {

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	@JsonProperty("name")
	private String name;

}
