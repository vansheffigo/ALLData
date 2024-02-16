package com.example.portal.service.impl;

import org.springframework.stereotype.Service;

import com.example.portal.dto.mapper.CategoryMapper;
import com.example.portal.dto.request.CategoryRequest;
import com.example.portal.dto.response.CategoryResponse;
import com.example.portal.entity.CategoryEntity;
import com.example.portal.repository.CategoryRepository;
import com.example.portal.service.CategoryService;

@Service
public class CategoryServiceimpl implements CategoryService {

	CategoryRepository categoryRepository;

	public CategoryServiceimpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public CategoryResponse saveCategory(CategoryRequest categoryRequest) {
		CategoryEntity categoryEntity = CategoryMapper.MAPPER.fromRequestToEntity(categoryRequest);
		categoryRepository.save(categoryEntity);

		return CategoryMapper.MAPPER.fromEntityTOResponse(categoryEntity);
	}

}
