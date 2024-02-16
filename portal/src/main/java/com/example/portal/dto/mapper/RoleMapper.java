package com.example.portal.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.portal.dto.request.RoleRequest;
import com.example.portal.dto.response.RoleResponse;
import com.example.portal.entity.RoleEntity;

@Mapper
public interface RoleMapper {

	RoleMapper MAPPER = Mappers.getMapper(RoleMapper.class);

	RoleEntity fromRequestToEntity(RoleRequest roleRequest);

	RoleResponse fromEntityTOResponse(RoleEntity roleEntity);
}
