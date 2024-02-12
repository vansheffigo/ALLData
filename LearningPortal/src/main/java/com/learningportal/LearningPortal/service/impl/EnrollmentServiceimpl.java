package com.learningportal.LearningPortal.service.impl;

import org.springframework.stereotype.Service;

import com.learningportal.LearningPortal.dto.Request.EnrollmentRequest;
import com.learningportal.LearningPortal.dto.Response.EnrollmentResponse;
import com.learningportal.LearningPortal.repository.EnrollementRepository;
import com.learningportal.LearningPortal.service.EnrollmentService;

@Service
public class EnrollmentServiceimpl implements EnrollmentService {

	EnrollementRepository enrollementRepository;

	public EnrollmentServiceimpl(EnrollementRepository enrollementRepository) {
		super();
		this.enrollementRepository = enrollementRepository;
	}

	@Override
	public EnrollmentResponse saveEnrollment(EnrollmentRequest enrollmentRequest) {
		return null;
	}

}
