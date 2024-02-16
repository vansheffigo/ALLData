package com.example.portal.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.portal.dto.request.CategoryRequest;
import com.example.portal.dto.response.CategoryResponse;
import com.example.portal.entity.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class);

	CategoryEntity fromRequestToEntity(CategoryRequest courseRequest);

	CategoryResponse fromEntityTOResponse(CategoryEntity courseEntity);
}
