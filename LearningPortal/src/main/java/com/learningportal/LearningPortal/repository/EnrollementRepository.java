package com.learningportal.LearningPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningportal.LearningPortal.Entity.EnrollmentEntity;

public interface EnrollementRepository extends JpaRepository<EnrollmentEntity, Long> {

}
