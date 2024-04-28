package com.example.debitcreditproject.dto.mapper;

import org.mapstruct.Mapper;

import com.example.debitcreditproject.dto.request.GrnRequest;
import com.example.debitcreditproject.dto.response.GrnResponse;
import com.example.debitcreditproject.entity.GrnEntityDetails;

@Mapper(componentModel = "spring")
public interface GrnMapper {

	GrnEntityDetails fromRequestToEntity(GrnRequest grnRequest);

	GrnResponse fromEntityToResponse(GrnEntityDetails grnEntity);
}
