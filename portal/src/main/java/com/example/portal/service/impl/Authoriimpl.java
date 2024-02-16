package com.example.portal.service.impl;

import org.springframework.stereotype.Service;

import com.example.portal.dto.mapper.AuthorMapper;
import com.example.portal.dto.request.AuthorRequest;
import com.example.portal.dto.response.AuthorResponse;
import com.example.portal.entity.AuthorEntity;
import com.example.portal.repository.AuthorRepository;
import com.example.portal.service.AuthorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Authoriimpl implements AuthorService {

	public Authoriimpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
		super();
		this.authorRepository = authorRepository;
		this.authorMapper = authorMapper;
	}

	private final AuthorRepository authorRepository;
	private final AuthorMapper authorMapper;

	@Override
	public AuthorResponse saveAuthor(AuthorRequest authorRequest) {
		log.info(authorRequest.toString());
		AuthorEntity authorEntity = authorMapper.fromRequestToEntity(authorRequest);
		log.info("This is Author Entity {}", authorEntity);
		authorRepository.save(authorEntity);
		return authorMapper.fromEntityToResponse(authorEntity);

	}

}
