package com.learningportal.LearningPortal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningportal.LearningPortal.Entity.AdminEntity;
import com.learningportal.LearningPortal.Entity.CoursesEntity;
import com.learningportal.LearningPortal.dto.Mapper.CourseMapper;
import com.learningportal.LearningPortal.dto.Request.CourseRequest;
import com.learningportal.LearningPortal.dto.Response.CourseResponse;
import com.learningportal.LearningPortal.repository.AdminRepository;
import com.learningportal.LearningPortal.repository.CourseRepository;
import com.learningportal.LearningPortal.service.CourseService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseServiceimpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private AdminRepository adminRepository;

	CourseServiceimpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	public CourseResponse saveCourse(Long user_id, Long course_id, CourseRequest courseRequest) {

		CoursesEntity courseEntity = CourseMapper.MAPPER.fromRequestToEntity(courseRequest);
		System.out.println(courseRequest);
		System.out.println(user_id);
		AdminEntity users = adminRepository.findById(user_id)
				.orElseThrow(() -> new EntityNotFoundException("Admin not found with id: " + user_id));

		courseEntity.getUsers().add(users);
		courseRepository.save(courseEntity);
		return CourseMapper.MAPPER.fromEntityTOResponse(courseEntity);

	}
}
