package com.learningportal.LearningPortal.dto.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.learningportal.LearningPortal.Entity.CategoryEntity;
import com.learningportal.LearningPortal.dto.Request.CategoryRequest;
import com.learningportal.LearningPortal.dto.Response.CategoryResponse;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class);

	CategoryEntity fromRequestToEntity(CategoryRequest courseRequest);

	CategoryResponse fromEntityTOResponse(CategoryEntity courseEntity);
}
