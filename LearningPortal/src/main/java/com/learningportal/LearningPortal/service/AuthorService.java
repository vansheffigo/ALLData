package com.learningportal.LearningPortal.service;

import com.learningportal.LearningPortal.dto.Request.AuthorRequest;
import com.learningportal.LearningPortal.dto.Response.AuthorResponse;

public interface AuthorService {

	AuthorResponse saveAuthor(AuthorRequest authorRequest);
}
