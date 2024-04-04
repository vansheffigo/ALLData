package com.example.debitcreditproject.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StatusUpdateDto {

	@JsonProperty("invoiceNumbers")
	List<String> invoiceNumbers;

	@JsonProperty("file")
	MultipartFile file;
}
