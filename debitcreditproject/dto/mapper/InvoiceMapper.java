package com.example.debitcreditproject.dto.mapper;

import org.mapstruct.Mapper;

import com.example.debitcreditproject.dto.request.InvoiceRequest;
import com.example.debitcreditproject.dto.response.InvoiceResponse;
import com.example.debitcreditproject.entity.InvoiceEntity;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

	InvoiceEntity fromRequestToEntity(InvoiceRequest invoiceRequest);

	InvoiceResponse fromEntityToResponse(InvoiceEntity invoiceEntity);
}
