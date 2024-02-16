package com.example.portal.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "courses")
public class CoursesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseId;
	@Column(name = "title")
	private String courseTitle;

	@ManyToOne
	private CategoryEntity catogeries;
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private Set<FavoritesEntity> favorite = new HashSet<>();
}
