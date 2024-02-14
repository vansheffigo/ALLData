package com.learningportal.LearningPortal.service;

import java.util.List;

import com.learningportal.LearningPortal.Entity.CoursesEntity;
import com.learningportal.LearningPortal.dto.Request.CourseRequest;
import com.learningportal.LearningPortal.dto.Response.CourseResponse;

public interface CourseService {

	CourseResponse saveCourse(Long user_id, Long course_id, String category_id, CourseRequest courserequest);

	List<CoursesEntity> findAllCourses();
}
