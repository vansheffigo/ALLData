package com.example.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portal.entity.CoursesEntity;

@Repository
public interface CourseRepository extends JpaRepository<CoursesEntity, Long> {

}
