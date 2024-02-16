package com.example.portal.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.portal.dto.request.FavoriteRequest;
import com.example.portal.dto.response.FavoriteResponse;
import com.example.portal.entity.FavoritesEntity;

@Mapper(componentModel = "spring")
public interface FavoriteMapper {

	FavoriteMapper MAPPER = Mappers.getMapper(FavoriteMapper.class);

	FavoritesEntity fromRequestToEntity(FavoriteRequest favoriteRequest);

	FavoriteResponse fromEntityTOResponse(FavoritesEntity favoriteEntity);

}
