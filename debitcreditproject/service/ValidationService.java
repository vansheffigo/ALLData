package com.example.debitcreditproject.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ValidationService {

	String validationFunction(MultipartFile file, List<String> links);

	Boolean uploadfun();

	String sendData();

	String sendUpdatedData(MultipartFile file, List<String> invoiceNumbers);

	void updateStatusPending(List<String> invoiceNumbers);

	String fetchAllData();
}
