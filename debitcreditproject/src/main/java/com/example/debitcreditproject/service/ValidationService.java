package com.example.debitcreditproject.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.debitcreditproject.dto.request.GrnRequest;
import com.example.debitcreditproject.dto.request.InvoiceRequest;
import com.example.debitcreditproject.dto.request.MaterialRequest;
import com.example.debitcreditproject.dto.request.PoItemRequest;
import com.example.debitcreditproject.dto.request.PoRequest;
import com.example.debitcreditproject.dto.request.VendorRequest;
import com.example.debitcreditproject.dto.response.GrnResponse;
import com.example.debitcreditproject.dto.response.InvoiceResponse;
import com.example.debitcreditproject.dto.response.MaterialResponse;
import com.example.debitcreditproject.dto.response.PoItemResponse;
import com.example.debitcreditproject.dto.response.PoResponse;
import com.example.debitcreditproject.dto.response.VendorResponse;

public interface ValidationService {

	GrnResponse saveGrn(GrnRequest grnRequest);

	InvoiceResponse saveInvoice(InvoiceRequest inoviceRequest);

	PoResponse savePo(PoRequest poRequest);

	VendorResponse saveVendor(VendorRequest vendorRequest);

	MaterialResponse saveMaterial(MaterialRequest materialRequest);

	PoItemRequest savePoItem(PoItemResponse poItemResponse);

	ResponseEntity<?> validationFunction(MultipartFile file);
}
