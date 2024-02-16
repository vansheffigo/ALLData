package com.example.portal.dto.mapper;

import org.mapstruct.Mapper;

import com.example.portal.dto.request.AdminRequest;
import com.example.portal.dto.response.AdminResponse;
import com.example.portal.entity.AdminEntity;

@Mapper(componentModel = "spring")
public interface AdminMapper {

	AdminEntity fromRequestToEntity(AdminRequest adminRequest);

	AdminResponse fromEntityToResponse(AdminEntity adminEntity);
}
