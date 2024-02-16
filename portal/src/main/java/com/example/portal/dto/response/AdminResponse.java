package com.example.portal.dto.response;

import lombok.Data;

@Data
public class AdminResponse {

	private Long adminId;
	private String email;

	private String password;
	private String name;

}
