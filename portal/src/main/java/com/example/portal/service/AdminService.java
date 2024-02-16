package com.example.portal.service;

import java.util.List;

import com.example.portal.dto.request.AdminRequest;
import com.example.portal.dto.response.AdminResponse;
import com.example.portal.entity.AdminEntity;

public interface AdminService {

	AdminResponse saveAdmin(AdminRequest adminRequest);

	List<AdminEntity> findAllUsers();

	AdminEntity findByEmail(String email);

	void deleteuser(String email);

	List<AdminEntity> fetchCombined();
}
