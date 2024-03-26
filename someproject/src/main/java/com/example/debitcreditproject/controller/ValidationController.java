package com.example.debitcreditproject.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.debitcreditproject.service.ValidationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ValidationController {

	private final ValidationService validationService;

	public ValidationController(ValidationService validationService) {
		super();
		this.validationService = validationService;
	}

	@GetMapping("/upload")
	public Boolean uploadfunction() {

		return validationService.uploadfun();
	}

	@GetMapping("/sendData")
	public String sendClienData() {
		return validationService.sendData();
	}

	@PostMapping("/validate")
	public String validation(@RequestParam("file") MultipartFile file) {

		log.info(validationService.validationFunction(file).getClass().getName() + "Running the validation api");
		return validationService.validationFunction(file);
	}

}
