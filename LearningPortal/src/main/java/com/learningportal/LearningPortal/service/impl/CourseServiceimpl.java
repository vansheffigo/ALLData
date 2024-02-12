package com.learningportal.LearningPortal.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningportal.LearningPortal.Entity.AdminEntity;
import com.learningportal.LearningPortal.Entity.CategoryEntity;
import com.learningportal.LearningPortal.Entity.CoursesEntity;
import com.learningportal.LearningPortal.dto.Mapper.CourseMapper;
import com.learningportal.LearningPortal.dto.Request.CourseRequest;
import com.learningportal.LearningPortal.dto.Response.CourseResponse;
import com.learningportal.LearningPortal.repository.AdminRepository;
import com.learningportal.LearningPortal.repository.CategoryRepository;
import com.learningportal.LearningPortal.repository.CourseRepository;
import com.learningportal.LearningPortal.service.CourseService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseServiceimpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	CourseServiceimpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	public CourseResponse saveCourse(Long user_id, Long course_id, String category_name, CourseRequest courseRequest) {

		CoursesEntity courseEntity = CourseMapper.MAPPER.fromRequestToEntity(courseRequest);
		System.out.println(courseRequest);

		AdminEntity users = adminRepository.findById(user_id)
				.orElseThrow(() -> new EntityNotFoundException("Admin not found with id: " + user_id));

		Optional<CategoryEntity> optionalCategory = categoryRepository.findByName(category_name);
		if (optionalCategory.isPresent()) {
			CategoryEntity category = optionalCategory.get();
			courseEntity.setCatogeries(category);
		} else {
			CategoryEntity newCategoryEntity = new CategoryEntity();

			newCategoryEntity.setDescription("new coourse addded");
			newCategoryEntity.setName(category_name);

			categoryRepository.save(newCategoryEntity);
			courseEntity.setCatogeries(newCategoryEntity);
		}
		courseEntity.getUsers().add(users);
		courseRepository.save(courseEntity);
		return CourseMapper.MAPPER.fromEntityTOResponse(courseEntity);

	}
}
