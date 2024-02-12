package com.learningportal.LearningPortal.service.impl;

import org.springframework.stereotype.Service;

import com.learningportal.LearningPortal.Entity.UserEntity;
import com.learningportal.LearningPortal.dto.Mapper.UserMapper;
import com.learningportal.LearningPortal.dto.Request.UserRequest;
import com.learningportal.LearningPortal.dto.Response.UserResponse;
import com.learningportal.LearningPortal.repository.UserRepository;

@Service
public class UserServiceImpl {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public UserResponse saveUser(UserRequest userRequest) {
		UserEntity userEntity = UserMapper.MAPPER.fromRequestToEntity(userRequest);

		userRepository.save(userEntity);
		return UserMapper.MAPPER.fromEntityTOResponse(userEntity);
	}
}
