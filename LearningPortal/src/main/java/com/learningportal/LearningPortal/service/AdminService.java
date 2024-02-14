package com.learningportal.LearningPortal.service;

import java.util.List;

import com.learningportal.LearningPortal.Entity.AdminEntity;
import com.learningportal.LearningPortal.dto.Request.AdminRequest;
import com.learningportal.LearningPortal.dto.Response.AdminResponse;

public interface AdminService {

	AdminResponse saveAdmin(AdminRequest adminRequest);

	List<AdminEntity> findAllUsers();

	AdminEntity findByEmail(String name);

}
