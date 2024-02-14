package com.learningportal.LearningPortal.service;

import com.learningportal.LearningPortal.dto.Response.FavoriteResponse;

public interface FavoriteService {

	FavoriteResponse addFavorite(Long userId, Long CourseId);
}
