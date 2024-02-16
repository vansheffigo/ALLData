package com.example.portal.service;

import com.example.portal.dto.response.FavoriteResponse;

public interface FavoriteService {

	FavoriteResponse addFavorite(Long userId, Long courseId);
}
