package com.learningportal.LearningPortal.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Courses")
public class CoursesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "Title")
	private String title;

//	@OneToMany(mappedBy = "Course")
//	private List<Enrollment> enrollments = new ArrayList<>();
//	@OneToMany(mappedBy = "Admin_id")
//	private List<AdminEntity> adminEntity = new ArrayList<>();
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_course", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<AdminEntity> users = new HashSet<>();
	@ManyToOne
	private CategoryEntity catogeries;
}
