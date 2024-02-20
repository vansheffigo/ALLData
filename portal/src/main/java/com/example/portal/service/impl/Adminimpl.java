package com.example.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.portal.dto.mapper.AdminMapper;
import com.example.portal.dto.request.AdminRequest;
import com.example.portal.dto.response.AdminResponse;
import com.example.portal.entity.AdminEntity;
import com.example.portal.entity.RoleEntity;
import com.example.portal.repository.AdminRepository;
import com.example.portal.repository.RoleRepository;
import com.example.portal.service.AdminService;

import jakarta.transaction.Transactional;

@Service
public class Adminimpl implements AdminService {

	private final AdminRepository adminRepository;

	private final RoleRepository roleRepository;
	private final AdminMapper adminMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Adminimpl(AdminRepository adminRepository, RoleRepository roleRepository, AdminMapper adminMapper) {
		super();
		this.adminRepository = adminRepository;
		this.roleRepository = roleRepository;
		this.adminMapper = adminMapper;

	}

	@Override
	public AdminResponse saveAdmin(AdminRequest adminRequest) {

		AdminEntity getuser = adminRepository.findByEmail(adminRequest.getEmail());
		if (getuser != null)
			return null;

		AdminEntity adminEntity = adminMapper.fromRequestToEntity(adminRequest);
		adminEntity.setPassword(this.passwordEncoder.encode(adminEntity.getPassword()));
		RoleEntity learnerRole = roleRepository.findByRole("Learner");
		if (learnerRole == null) {
			learnerRole = new RoleEntity();
			learnerRole.setRole("Learner");
			roleRepository.save(learnerRole);
		}
		adminEntity.getRoles().add(learnerRole);

		adminRepository.save(adminEntity);

		return adminMapper.fromEntityToResponse(adminEntity);
	}

	@Override
	public List<AdminEntity> findAllUsers() {
		return adminRepository.findAll();
	}

	@Override
	public AdminEntity findByEmail(String email) {

		AdminEntity adminEntity = adminRepository.findByEmail(email);
		if (adminEntity == null)
			return null;
		return adminEntity;
	}

	@Override
	@Transactional
	public void deleteuser(String email) {
		AdminEntity adminEntity = adminRepository.findByEmail(email);
		if (adminEntity != null) {
			adminEntity.getRoles().clear();
			adminEntity.getCourses().clear();
			adminEntity.getFavorite().clear();
			adminRepository.save(adminEntity);
			adminRepository.delete(adminEntity);
		}
	}

	public List<AdminEntity> fetchCombined() {

		return adminRepository.fetchCombined();
	}

}
