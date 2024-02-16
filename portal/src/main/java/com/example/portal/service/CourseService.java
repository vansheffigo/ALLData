package com.example.portal.service;

import java.util.List;

import com.example.portal.dto.request.CourseRequest;
import com.example.portal.dto.response.CourseResponse;
import com.example.portal.entity.CoursesEntity;

public interface CourseService {

	CourseResponse saveCourse(CourseRequest courseRequest);

	List<CoursesEntity> findAllCourses();
}
