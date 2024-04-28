package com.example.debitcreditproject.dto.mapper;

import org.mapstruct.Mapper;

import com.example.debitcreditproject.dto.request.PoRequest;
import com.example.debitcreditproject.dto.response.PoResponse;
import com.example.debitcreditproject.entity.PoEntityDetails;

@Mapper(componentModel = "spring")
public interface PoMapper {

	PoEntityDetails fromRequestToEntity(PoRequest poRequest);

	PoResponse fromEntityToResponse(PoEntityDetails poEntity);
}
