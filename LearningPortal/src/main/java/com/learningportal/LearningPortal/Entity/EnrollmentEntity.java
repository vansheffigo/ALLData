package com.learningportal.LearningPortal.Entity;

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
@Table(name = "Enrollement")
public class EnrollmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@ManyToOne(mappedBy = "Learner")
//	private UserEntity Learner;
//
//	@ManyToOne
//	private CoursesEntity Course;
	@ManyToOne
	@JoinColumn(name = "Course_id")
	private CoursesEntity ChosenCourses;
}
