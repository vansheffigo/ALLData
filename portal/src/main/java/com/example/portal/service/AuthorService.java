package com.example.portal.service;

import com.example.portal.dto.request.AuthorRequest;
import com.example.portal.dto.response.AuthorResponse;

public interface AuthorService {

	AuthorResponse saveAuthor(AuthorRequest authorRequest);
}
