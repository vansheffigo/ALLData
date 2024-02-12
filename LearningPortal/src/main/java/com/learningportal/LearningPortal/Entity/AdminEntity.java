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
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Admin")
public class AdminEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Admin_id;
	@Column(name = "Email")
	private String email;
	@Column(name = "Password")
	private String password;

	@Column(name = "Name")
	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Admin_Role", joinColumns = @JoinColumn(name = "Admin_id", referencedColumnName = "Admin_id"), inverseJoinColumns = @JoinColumn(name = "Role_id", referencedColumnName = "Role_id"))
	private Set<RoleEntity> roles = new HashSet<>();

//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "Enrollments", joinColumns = @JoinColumn(name = "Admin_id"), inverseJoinColumns = @JoinColumn(name = "Course_id"))
//	private Set<CoursesEntity> enrolledcourses = new HashSet<>();
	// @OneToMany
//	private List<CategoryEntity> categoryEntity = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<CoursesEntity> courses = new HashSet<CoursesEntity>();
}
