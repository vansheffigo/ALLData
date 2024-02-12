package com.learningportal.LearningPortal.service;

import com.learningportal.LearningPortal.dto.Request.UserRequest;
import com.learningportal.LearningPortal.dto.Response.UserResponse;

public interface UserService {
	UserResponse saveUser(UserRequest userRequest);
}
