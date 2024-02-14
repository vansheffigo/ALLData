package com.learningportal.LearningPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningportal.LearningPortal.Entity.FavoritesEntity;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoritesEntity, Long> {

}
