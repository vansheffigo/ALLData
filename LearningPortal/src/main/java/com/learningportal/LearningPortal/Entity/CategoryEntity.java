package com.learningportal.LearningPortal.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Category")
@Data
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Name")
	private String name;
	@Column(name = "decription")
	private String description;

//	@OneToMany(mappedBy = "courses")
//	private CoursesEntity courses;

}
