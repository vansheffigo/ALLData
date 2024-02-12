package com.learningportal.LearningPortal.service;

import com.learningportal.LearningPortal.dto.Request.CategoryRequest;
import com.learningportal.LearningPortal.dto.Response.CategoryResponse;

public interface CategoryService {

	CategoryResponse saveCategory(CategoryRequest categoryRequest);
}
