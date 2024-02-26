package com.learningportal.LearningPortal.dto.Mapper;

import com.learningportal.LearningPortal.Entity.FavoritesEntity;
import com.learningportal.LearningPortal.dto.Request.FavoriteRequest;
import com.learningportal.LearningPortal.dto.Response.FavoriteResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-16T11:54:07+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class FavoriteMapperImpl implements FavoriteMapper {

    @Override
    public FavoritesEntity fromRequestToEntity(FavoriteRequest favoriteRequest) {
        if ( favoriteRequest == null ) {
            return null;
        }

        FavoritesEntity favoritesEntity = new FavoritesEntity();

        return favoritesEntity;
    }

    @Override
    public FavoriteResponse fromEntityTOResponse(FavoritesEntity favoriteEntity) {
        if ( favoriteEntity == null ) {
            return null;
        }

        FavoriteResponse favoriteResponse = new FavoriteResponse();

        favoriteResponse.setId( favoriteEntity.getId() );

        return favoriteResponse;
    }
}
