package com.example.debitcreditproject.dto.mapper;

import org.mapstruct.Mapper;

import com.example.debitcreditproject.dto.request.MaterialRequest;
import com.example.debitcreditproject.dto.response.MaterialResponse;
import com.example.debitcreditproject.entity.MaterialEntity;

@Mapper(componentModel = "spring")
public interface MaterialMapper {

	MaterialEntity fromRequestToEntity(MaterialRequest materialRequest);

	MaterialResponse fromEntityToResponse(MaterialEntity materialEntity);
}
