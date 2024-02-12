package com.learningportal.LearningPortal.dto.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.learningportal.LearningPortal.Entity.AdminEntity;
import com.learningportal.LearningPortal.dto.Request.AdminRequest;
import com.learningportal.LearningPortal.dto.Response.AdminResponse;

@Mapper(componentModel = "spring")
public interface AdminMapper {

	AdminMapper MAPPER = Mappers.getMapper(AdminMapper.class);

	AdminEntity fromRequestToEntity(AdminRequest adminRequest);

	AdminResponse fromEntityToResponse(AdminEntity adminEntity);
}
