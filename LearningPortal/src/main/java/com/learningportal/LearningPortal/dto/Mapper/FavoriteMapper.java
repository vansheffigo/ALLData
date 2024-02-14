package com.learningportal.LearningPortal.dto.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.learningportal.LearningPortal.Entity.FavoritesEntity;
import com.learningportal.LearningPortal.dto.Request.FavoriteRequest;
import com.learningportal.LearningPortal.dto.Response.FavoriteResponse;

@Mapper(componentModel = "spring")
public interface FavoriteMapper {

	FavoriteMapper MAPPER = Mappers.getMapper(FavoriteMapper.class);

	FavoritesEntity fromRequestToEntity(FavoriteRequest favoriteRequest);

	FavoriteResponse fromEntityTOResponse(FavoritesEntity favoriteEntity);

}
