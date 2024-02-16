package com.example.portal.service;

import com.example.portal.dto.request.RoleRequest;
import com.example.portal.dto.response.RoleResponse;

public interface RoleService {

	RoleResponse saveRole(RoleRequest rolerequest);
}
