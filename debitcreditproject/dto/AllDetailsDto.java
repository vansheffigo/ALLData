package com.example.debitcreditproject.dto;

import com.example.debitcreditproject.entity.GrnEntity;
import com.example.debitcreditproject.entity.GrnItem;
import com.example.debitcreditproject.entity.InvoiceEntity;
import com.example.debitcreditproject.entity.MaterialEntity;
import com.example.debitcreditproject.entity.PoEntity;
import com.example.debitcreditproject.entity.PoItem;
import com.example.debitcreditproject.entity.VendorEntity;

import lombok.Value;

@Value
public class AllDetailsDto {
	private Long id;
	GrnEntity grnEntity;
	VendorEntity vendorEntity;
	InvoiceEntity invoiceEntity;
	MaterialEntity materialEntity;
	PoEntity poEntity;
	PoItem poItem;
	GrnItem grnItem;
}
