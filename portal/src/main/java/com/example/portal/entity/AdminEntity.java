package com.example.portal.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "admin")
public class AdminEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adminId;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "admin_Role", joinColumns = @JoinColumn(name = "adminId", referencedColumnName = "adminId"), inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "roleId"))
	private Set<RoleEntity> roles = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<CoursesEntity> courses = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<FavoritesEntity> favorite = new HashSet<>();

}
