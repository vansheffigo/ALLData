package com.learningportal.LearningPortal.service.impl;

import org.springframework.stereotype.Service;

import com.learningportal.LearningPortal.Entity.CategoryEntity;
import com.learningportal.LearningPortal.dto.Mapper.CategoryMapper;
import com.learningportal.LearningPortal.dto.Request.CategoryRequest;
import com.learningportal.LearningPortal.dto.Response.CategoryResponse;
import com.learningportal.LearningPortal.repository.CategoryRepository;
import com.learningportal.LearningPortal.service.CategoryService;

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
