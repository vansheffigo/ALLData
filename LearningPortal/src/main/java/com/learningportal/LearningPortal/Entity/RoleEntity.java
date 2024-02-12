package com.learningportal.LearningPortal.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Role")
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Role_id;
	@Column(name = "Role")
	private String role = "Learner";
	@ManyToMany(mappedBy = "roles")
	private Set<AdminEntity> admins = new HashSet<>();

}
