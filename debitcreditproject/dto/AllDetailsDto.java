package com.example.debitcreditproject.dto;

import com.example.debitcreditproject.entity.GrnEntityDetails;
import com.example.debitcreditproject.entity.GrnItemDetails;
import com.example.debitcreditproject.entity.InvoiceEntityDetails;
import com.example.debitcreditproject.entity.MaterialEntityDetails;
import com.example.debitcreditproject.entity.PoEntityDetails;
import com.example.debitcreditproject.entity.PoItemDetails;
import com.example.debitcreditproject.entity.VendorEntityDetails;

import lombok.Value;

@Value
public class AllDetailsDto {
	private Long id;
	GrnEntityDetails grnEntity;
	VendorEntityDetails vendorEntity;
	InvoiceEntityDetails invoiceEntity;
	MaterialEntityDetails materialEntity;
	PoEntityDetails poEntity;
	PoItemDetails poItem;
	GrnItemDetails grnItem;
}
