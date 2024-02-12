package com.learningportal.LearningPortal.dto.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.learningportal.LearningPortal.Entity.AuthorEntity;
import com.learningportal.LearningPortal.dto.Request.AuthorRequest;
import com.learningportal.LearningPortal.dto.Response.AuthorResponse;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

	AuthorMapper MAPPER = Mappers.getMapper(AuthorMapper.class);

	AuthorEntity fromRequestToEntity(AuthorRequest authorRequest);

	AuthorResponse fromEntityToResponse(AuthorEntity authorEntity);

}
