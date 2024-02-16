package com.example.portal.service;

import com.example.portal.dto.request.CategoryRequest;
import com.example.portal.dto.response.CategoryResponse;

public interface CategoryService {

	CategoryResponse saveCategory(CategoryRequest categoryRequest);
}
