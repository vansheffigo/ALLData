package com.example.debitcreditproject.dto.mapper;

import org.mapstruct.Mapper;

import com.example.debitcreditproject.dto.request.MaterialRequest;
import com.example.debitcreditproject.dto.response.MaterialResponse;
import com.example.debitcreditproject.entity.MaterialEntityDetails;

@Mapper(componentModel = "spring")
public interface MaterialMapper {

	MaterialEntityDetails fromRequestToEntity(MaterialRequest materialRequest);

	MaterialResponse fromEntityToResponse(MaterialEntityDetails materialEntity);
}
