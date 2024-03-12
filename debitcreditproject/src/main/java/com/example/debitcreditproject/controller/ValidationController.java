package com.example.debitcreditproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.debitcreditproject.service.ValidationService;

@RestController
@RequestMapping("/api")
public class ValidationController {

	private final ValidationService validationService;

	public ValidationController(ValidationService validationService) {
		super();
		this.validationService = validationService;
	}

	@GetMapping("/c")
	public int files() {
		return 1;
	}

	@PostMapping("/validate")
	public ResponseEntity<?> validation(@RequestParam("file") MultipartFile file) {
//		validationService.validationFunction(file);

		return ResponseEntity.ok("this s");
	}
}
