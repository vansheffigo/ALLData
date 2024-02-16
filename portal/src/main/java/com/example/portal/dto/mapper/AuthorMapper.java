package com.example.portal.dto.mapper;

import org.mapstruct.Mapper;

import com.example.portal.dto.request.AuthorRequest;
import com.example.portal.dto.response.AuthorResponse;
import com.example.portal.entity.AuthorEntity;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

	AuthorEntity fromRequestToEntity(AuthorRequest authorRequest);

	AuthorResponse fromEntityToResponse(AuthorEntity authorEntity);

}
