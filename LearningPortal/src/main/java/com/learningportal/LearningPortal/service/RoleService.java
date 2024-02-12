package com.learningportal.LearningPortal.service;

import com.learningportal.LearningPortal.dto.Request.RoleRequest;
import com.learningportal.LearningPortal.dto.Response.RoleResponse;

public interface RoleService {

	RoleResponse saveRole(RoleRequest rolerequest);
}
