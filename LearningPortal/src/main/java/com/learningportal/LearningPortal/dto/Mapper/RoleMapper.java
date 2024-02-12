package com.learningportal.LearningPortal.dto.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.learningportal.LearningPortal.Entity.RoleEntity;
import com.learningportal.LearningPortal.dto.Request.RoleRequest;
import com.learningportal.LearningPortal.dto.Response.RoleResponse;

@Mapper
public interface RoleMapper {

	RoleMapper MAPPER = Mappers.getMapper(RoleMapper.class);

	RoleEntity fromRequestToEntity(RoleRequest roleRequest);

	RoleResponse fromEntityTOResponse(RoleEntity roleEntity);
}
