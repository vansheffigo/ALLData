package com.example.debitcreditproject.dto.mapper;

import org.mapstruct.Mapper;

import com.example.debitcreditproject.dto.request.PoRequest;
import com.example.debitcreditproject.dto.response.PoResponse;
import com.example.debitcreditproject.entity.PoEntity;

@Mapper(componentModel = "spring")
public interface PoMapper {

	PoEntity fromRequestToEntity(PoRequest poRequest);

	PoResponse fromEntityToResponse(PoEntity poEntity);
}
