
package com.learningportal.LearningPortal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningportal.LearningPortal.Entity.AuthorEntity;
import com.learningportal.LearningPortal.dto.Mapper.AuthorMapper;
import com.learningportal.LearningPortal.dto.Request.AuthorRequest;
import com.learningportal.LearningPortal.dto.Response.AuthorResponse;
import com.learningportal.LearningPortal.repository.AuthorRepository;
import com.learningportal.LearningPortal.service.AuthorService;

@Service
public class Authoriimpl implements AuthorService {
	@Autowired
	AuthorRepository authorRepository;

	@Override
	public AuthorResponse saveAuthor(AuthorRequest authorRequest) {
		AuthorEntity authorEntity = AuthorMapper.MAPPER.fromRequestToEntity(authorRequest);

		authorRepository.save(authorEntity);
		return AuthorMapper.MAPPER.fromEntityToResponse(authorEntity);

	}

}
