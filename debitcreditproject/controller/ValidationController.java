package com.example.debitcreditproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.debitcreditproject.dto.StatusUpdateDto;
import com.example.debitcreditproject.dto.request.LinkDto;
import com.example.debitcreditproject.service.ValidationService;
import com.example.debitcreditproject.utils.CustomMultipartFile;

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
	public String validate(@RequestBody LinkDto links) {

		RestTemplate restTemplate = new RestTemplate();
		MultipartFile excelFile = null;
		List<String> pdfs = new ArrayList<String>();
		for (String link : links.getUrls()) {
			if (isPdf(link)) {
				pdfs.add(link);
			} else if (isExcel(link)) {
				excelFile = fetchExcelFile(restTemplate, link);
			}

		}

		return validationService.validationFunction(excelFile, pdfs);
	}

	// -----------------------
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	private boolean isPdf(String link) {
		String extension = FilenameUtils.getExtension(link);
		return "pdf".equalsIgnoreCase(extension);
	}

	private boolean isExcel(String link) {
		String extension = FilenameUtils.getExtension(link);
		return "xlsx".equalsIgnoreCase(extension) || "xls".equalsIgnoreCase(extension);
	}

	public MultipartFile fetchExcelFile(RestTemplate restTemplate, String url) {

		// Send a GET request to the URL
		byte[] response = restTemplate.getForObject(url, byte[].class);

		String[] fileName = url.split("/");

		MultipartFile file = new CustomMultipartFile(response, fileName[fileName.length - 1]);

		return file;

	}

	@PostMapping("/updateStatusPending")
	public void updateStatusPending(@RequestBody List<String> invoiceNumbers) {

		validationService.updateStatusPending(invoiceNumbers);
	}

	@PostMapping(value = "/updateStatusPass", consumes = { "multipart/form-data" })
	public String acceptList(StatusUpdateDto statusUpdateDto) {

		log.info("" + statusUpdateDto.getInvoiceNumbers());
		validationService.sendUpdatedData(statusUpdateDto.getFile(), statusUpdateDto.getInvoiceNumbers());
		return "status is updated in backend";
	}

	@GetMapping("/fetchAllData")
	public String fetchAllData() {

		return validationService.fetchAllData();
	}
}
