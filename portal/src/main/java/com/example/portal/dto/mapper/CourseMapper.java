package com.example.portal.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.portal.dto.request.CourseRequest;
import com.example.portal.dto.response.CourseResponse;
import com.example.portal.entity.CoursesEntity;

@Mapper(componentModel = "spring")
public interface CourseMapper {

	CourseMapper MAPPER = Mappers.getMapper(CourseMapper.class);

	CoursesEntity fromRequestToEntity(CourseRequest courseRequest);

	CourseResponse fromEntityTOResponse(CoursesEntity courseEntity);

}
