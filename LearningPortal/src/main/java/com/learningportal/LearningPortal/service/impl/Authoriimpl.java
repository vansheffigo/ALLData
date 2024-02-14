
package com.learningportal.LearningPortal.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(AuthorService.class);

	@Override
	public AuthorResponse saveAuthor(AuthorRequest authorRequest) {
		AuthorEntity authorEntity = AuthorMapper.MAPPER.fromRequestToEntity(authorRequest);
		logger.info("This is Author Entity" + authorEntity);
		authorRepository.save(authorEntity);
		return AuthorMapper.MAPPER.fromEntityToResponse(authorEntity);

	}

}
