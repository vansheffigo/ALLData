package com.learningportal.LearningPortal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningportal.LearningPortal.Entity.AdminEntity;
import com.learningportal.LearningPortal.Entity.CoursesEntity;
import com.learningportal.LearningPortal.Entity.FavoritesEntity;
import com.learningportal.LearningPortal.dto.Mapper.FavoriteMapper;
import com.learningportal.LearningPortal.dto.Response.FavoriteResponse;
import com.learningportal.LearningPortal.repository.AdminRepository;
import com.learningportal.LearningPortal.repository.CourseRepository;
import com.learningportal.LearningPortal.repository.FavoriteRepository;
import com.learningportal.LearningPortal.service.FavoriteService;

@Service
public class Favoriteimpl implements FavoriteService {

	@Autowired
	FavoriteRepository favoriteRepository;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	CourseRepository courseRepository;

	@Override
	public FavoriteResponse addFavorite(Long UserId, Long CourseId) {
		System.out.println("world");
		AdminEntity user = adminRepository.findById(UserId)
				.orElseThrow(() -> new IllegalArgumentException("User not found"));
		System.out.println("this");
		CoursesEntity course = courseRepository.findById(CourseId)
				.orElseThrow(() -> new IllegalArgumentException("course not found"));
		FavoritesEntity favorite = new FavoritesEntity();
		;

		favorite.setUser(user);
		favorite.setCourse(course);
		favoriteRepository.save(favorite);
		return FavoriteMapper.MAPPER.fromEntityTOResponse(favorite);
	}
}
