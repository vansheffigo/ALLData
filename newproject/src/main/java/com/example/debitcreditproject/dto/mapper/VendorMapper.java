package com.example.debitcreditproject.dto.mapper;

import org.mapstruct.Mapper;

import com.example.debitcreditproject.dto.request.VendorRequest;
import com.example.debitcreditproject.dto.response.VendorResponse;
import com.example.debitcreditproject.entity.VendorEntity;

@Mapper(componentModel = "spring")
public interface VendorMapper {

	VendorEntity fromRequestToEntity(VendorRequest vendorRequest);

	VendorResponse fromEntityToResponse(VendorEntity vendorEntity);
}
