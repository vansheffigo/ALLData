package com.example.portal.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Entity
@Table(name = "author")
public class AuthorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long authorId;
	@Column(name = "name")
	private String authorName;
	@Column(name = "course")
	private String authorCourse;

	@OneToMany
	private List<CoursesEntity> coursesEntity = new ArrayList<>();;
}