package com.learningportal.LearningPortal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningportal.LearningPortal.Entity.AdminEntity;
import com.learningportal.LearningPortal.Entity.RoleEntity;
import com.learningportal.LearningPortal.dto.Mapper.AdminMapper;
import com.learningportal.LearningPortal.dto.Request.AdminRequest;
import com.learningportal.LearningPortal.dto.Response.AdminResponse;
import com.learningportal.LearningPortal.repository.AdminRepository;
import com.learningportal.LearningPortal.repository.RoleRepository;
import com.learningportal.LearningPortal.service.AdminService;

@Service
public class Adminimpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public AdminResponse saveAdmin(AdminRequest adminRequest) {
		System.out.println("hello");
		AdminEntity adminEntity = AdminMapper.MAPPER.fromRequestToEntity(adminRequest);
		RoleEntity learnerRole = roleRepository.findByRole("Learner");// roleRepository.save(roleEntity);
		if (learnerRole == null) {
			// If "Learner" role doesn't exist, create and save it
			learnerRole = new RoleEntity();
			learnerRole.setRole("Learner");
			roleRepository.save(learnerRole);
		}
		adminEntity.getRoles().add(learnerRole);

		System.out.println(adminEntity.getEmail());
		adminRepository.save(adminEntity);

		return AdminMapper.MAPPER.fromEntityToResponse(adminEntity);
	}

	@Override
	public List<AdminEntity> findAllUsers() {
		return adminRepository.findAll();
	}

	@Override
	public AdminEntity findByEmail(String name) {
		return adminRepository.findByEmail(name);
	}

}
