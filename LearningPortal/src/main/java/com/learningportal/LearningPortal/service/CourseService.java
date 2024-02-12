package com.learningportal.LearningPortal.service;

import com.learningportal.LearningPortal.dto.Request.CourseRequest;
import com.learningportal.LearningPortal.dto.Response.CourseResponse;

public interface CourseService {

	CourseResponse saveCourse(Long user_id, Long course_id, CourseRequest courserequest);
}
