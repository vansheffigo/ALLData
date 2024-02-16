package com.example.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portal.entity.FavoritesEntity;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoritesEntity, Long> {

}
