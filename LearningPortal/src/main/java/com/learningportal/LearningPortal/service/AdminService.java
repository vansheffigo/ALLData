package com.learningportal.LearningPortal.service;

import com.learningportal.LearningPortal.dto.Request.AdminRequest;
import com.learningportal.LearningPortal.dto.Response.AdminResponse;

public interface AdminService {

	AdminResponse saveAdmin(AdminRequest adminRequest);
}
