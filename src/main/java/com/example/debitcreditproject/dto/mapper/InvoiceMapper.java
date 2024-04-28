package com.example.debitcreditproject.dto.mapper;

import org.mapstruct.Mapper;

import com.example.debitcreditproject.dto.request.InvoiceRequest;
import com.example.debitcreditproject.dto.response.InvoiceResponse;
import com.example.debitcreditproject.entity.InvoiceEntityDetails;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

	InvoiceEntityDetails fromRequestToEntity(InvoiceRequest invoiceRequest);

	InvoiceResponse fromEntityToResponse(InvoiceEntityDetails invoiceEntity);
}
