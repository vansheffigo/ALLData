package com.learningportal.LearningPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learningportal.LearningPortal.Entity.AdminEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
	@Query(value = "SELECT * FROM admin WHERE email = :email", nativeQuery = true)
	AdminEntity findByEmail(@Param("email") String email);

//	AdminEntity findByEmail(String email);
}
