package com.example.portal.service.impl;

import org.springframework.stereotype.Service;

import com.example.portal.dto.mapper.FavoriteMapper;
import com.example.portal.dto.response.FavoriteResponse;
import com.example.portal.entity.AdminEntity;
import com.example.portal.entity.CoursesEntity;
import com.example.portal.entity.FavoritesEntity;
import com.example.portal.repository.AdminRepository;
import com.example.portal.repository.CourseRepository;
import com.example.portal.repository.FavoriteRepository;
import com.example.portal.service.FavoriteService;

@Service
public class Favoriteimpl implements FavoriteService {

	final FavoriteRepository favoriteRepository;

	final AdminRepository adminRepository;

	final CourseRepository courseRepository;

	public Favoriteimpl(FavoriteRepository favoriteRepository, AdminRepository adminRepository,
			CourseRepository courseRepository) {
		super();
		this.favoriteRepository = favoriteRepository;
		this.adminRepository = adminRepository;
		this.courseRepository = courseRepository;
	}

	@Override
	public FavoriteResponse addFavorite(Long userId, Long courseId) {

		AdminEntity user = adminRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("User not found"));

		CoursesEntity course = courseRepository.findById(courseId)
				.orElseThrow(() -> new IllegalArgumentException("course not found"));
		FavoritesEntity favorite = new FavoritesEntity();

		favorite.setUser(user);
		favorite.setCourse(course);
		favoriteRepository.save(favorite);
		return FavoriteMapper.MAPPER.fromEntityTOResponse(favorite);
	}
}
