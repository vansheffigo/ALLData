package com.learningportal.LearningPortal.dto.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.learningportal.LearningPortal.Entity.CoursesEntity;
import com.learningportal.LearningPortal.dto.Request.CourseRequest;
import com.learningportal.LearningPortal.dto.Response.CourseResponse;

@Mapper(componentModel = "spring")
public interface CourseMapper {

	/////
	CourseMapper MAPPER = Mappers.getMapper(CourseMapper.class);

	CoursesEntity fromRequestToEntity(CourseRequest courseRequest);

	CourseResponse fromEntityTOResponse(CoursesEntity courseEntity);

}
