package com.learningportal.LearningPortal.service;

import com.learningportal.LearningPortal.dto.Request.EnrollmentRequest;
import com.learningportal.LearningPortal.dto.Response.EnrollmentResponse;

public interface EnrollmentService {
	EnrollmentResponse saveEnrollment(EnrollmentRequest enrollmentRequest);
}
