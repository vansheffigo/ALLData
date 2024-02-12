package com.learningportal.LearningPortal.service.impl;

import org.springframework.stereotype.Service;

import com.learningportal.LearningPortal.Entity.RoleEntity;
import com.learningportal.LearningPortal.dto.Mapper.RoleMapper;
import com.learningportal.LearningPortal.dto.Request.RoleRequest;
import com.learningportal.LearningPortal.dto.Response.RoleResponse;
import com.learningportal.LearningPortal.repository.RoleRepository;
import com.learningportal.LearningPortal.service.RoleService;

@Service
public class Roleimpl implements RoleService {
	private RoleRepository roleRepository;

	public Roleimpl(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@Override
	public RoleResponse saveRole(RoleRequest roleRequest) {
		RoleEntity roleEntity = RoleMapper.MAPPER.fromRequestToEntity(roleRequest);
		roleRepository.save(roleEntity);
		return RoleMapper.MAPPER.fromEntityTOResponse(roleEntity);

	}

}
