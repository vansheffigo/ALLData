package com.example.portal.service.impl;

import org.springframework.stereotype.Service;

import com.example.portal.dto.mapper.RoleMapper;
import com.example.portal.dto.request.RoleRequest;
import com.example.portal.dto.response.RoleResponse;
import com.example.portal.entity.RoleEntity;
import com.example.portal.repository.RoleRepository;
import com.example.portal.service.RoleService;

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
