package com.example.portal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.portal.entity.JwtRequest;
import com.example.portal.entity.JwtResponse;
import com.example.portal.jwt.JwtHelper;

import lombok.extern.slf4j.Slf4j;

@RestController

@Slf4j
public class JwtAuthenticationController {

	private UserDetailsService userDetailsService;

	private AuthenticationManager manager;

	private JwtHelper helper;

	public JwtAuthenticationController(UserDetailsService userDetailsService, AuthenticationManager manager,
			JwtHelper helper) {
		super();
		this.userDetailsService = userDetailsService;
		this.manager = manager;
		this.helper = helper;
	}

	@PostMapping("/authenticate")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

		this.doAuthenticate(request.getUsername(), request.getPassword());

		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.helper.generateToken(userDetails);

		JwtResponse response = JwtResponse.builder().jwtToken(token).username(userDetails.getUsername()).build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private void doAuthenticate(String username, String password) {
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,
				password);
		try {
			manager.authenticate(authentication);
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Credentials Invalid !!");
		}

	}
}
