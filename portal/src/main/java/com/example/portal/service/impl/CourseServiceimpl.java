package com.example.portal.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.portal.dto.mapper.CourseMapper;
import com.example.portal.dto.request.CourseRequest;
import com.example.portal.dto.response.CourseResponse;
import com.example.portal.entity.AdminEntity;
import com.example.portal.entity.CategoryEntity;
import com.example.portal.entity.CoursesEntity;
import com.example.portal.repository.AdminRepository;
import com.example.portal.repository.CategoryRepository;
import com.example.portal.repository.CourseRepository;
import com.example.portal.service.CourseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseServiceimpl implements CourseService {

	private final CourseRepository courseRepository;

	private final AdminRepository adminRepository;

	private final CategoryRepository categoryRepository;

	public CourseServiceimpl(CourseRepository courseRepository, AdminRepository adminRepository,
			CategoryRepository categoryRepository) {
		super();
		this.courseRepository = courseRepository;
		this.adminRepository = adminRepository;
		this.categoryRepository = categoryRepository;
	}

	public CourseResponse saveCourse(CourseRequest courseRequest) {

		CoursesEntity courseEntity = CourseMapper.MAPPER.fromRequestToEntity(courseRequest);
		Optional<CoursesEntity> getCourse = courseRepository.findById(courseRequest.getCourseId());

		Optional<CategoryEntity> optionalCategory = categoryRepository
				.findByCategoryName(courseRequest.getCategoryName());
		if (optionalCategory.isPresent()) {
			CategoryEntity category = optionalCategory.get();
			courseEntity.setCatogeries(category);
		} else {
			CategoryEntity newCategoryEntity = new CategoryEntity();

			newCategoryEntity.setCategoryDescription("new course added");
			newCategoryEntity.setCategoryName(courseRequest.getCategoryName());

			categoryRepository.save(newCategoryEntity);
			courseEntity.setCatogeries(newCategoryEntity);
		}

		if (getCourse.isEmpty()) {
			courseRepository.save(courseEntity);
		} else {

			courseEntity = getCourse.get();
		}
		AdminEntity users = adminRepository.findByEmail(courseRequest.getEmail());
		if (users == null) {

			return null;

		}
		Set<CoursesEntity> getCourses = users.getCourses();
		getCourses.add(courseEntity);
		users.setCourses(getCourses);

		adminRepository.save(users);
		return CourseMapper.MAPPER.fromEntityTOResponse(courseEntity);
	}

	@Override
	public List<CoursesEntity> findAllCourses() {
		return courseRepository.findAll();
	}
}
