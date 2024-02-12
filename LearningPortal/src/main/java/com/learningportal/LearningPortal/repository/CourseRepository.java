package com.learningportal.LearningPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningportal.LearningPortal.Entity.CoursesEntity;

@Repository
public interface CourseRepository extends JpaRepository<CoursesEntity, Long> {

}
