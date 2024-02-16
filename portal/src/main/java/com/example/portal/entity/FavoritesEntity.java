package com.example.portal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "favorites")
public class FavoritesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long favoriteId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private AdminEntity user;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private CoursesEntity course;

}