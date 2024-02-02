package com.in28minutes.springboot.mysampleproject.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	// authentication of user
	public boolean authenticate(String username, String password) {
		boolean isValidUserName = username.equalsIgnoreCase("in28minutes");
		boolean isValidPassword = password.equalsIgnoreCase(password);
		return isValidPassword && isValidUserName;
	}
}
