package com.example.debitcreditproject.dto.mapper;

import org.mapstruct.Mapper;

import com.example.debitcreditproject.dto.request.VendorRequest;
import com.example.debitcreditproject.dto.response.VendorResponse;
import com.example.debitcreditproject.entity.VendorEntityDetails;

@Mapper(componentModel = "spring")
public interface VendorMapper {

	VendorEntityDetails fromRequestToEntity(VendorRequest vendorRequest);

	VendorResponse fromEntityToResponse(VendorEntityDetails vendorEntity);
}
