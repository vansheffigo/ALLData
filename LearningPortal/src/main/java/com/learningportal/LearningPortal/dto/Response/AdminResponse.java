package com.learningportal.LearningPortal.dto.Response;

import lombok.Data;

@Data
public class AdminResponse {

	private Long Admin_id;
	private String email;

	private String password;
	private String name;

}
