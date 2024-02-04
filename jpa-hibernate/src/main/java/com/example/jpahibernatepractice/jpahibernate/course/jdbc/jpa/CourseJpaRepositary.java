package com.example.jpahibernatepractice.jpahibernate.course.jdbc.jpa;

import org.springframework.stereotype.Repository;

import com.example.jpahibernatepractice.jpahibernate.course.jdbc.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepositary {
	// instead of autowired more specific anontation persistancecontext
	@PersistenceContext
	private EntityManager entitymanager;

	public void insert(Course course) {
		entitymanager.merge(course);
	}

	public Course findById(long id) {

		return entitymanager.find(Course.class, id);
	}

	public void deleteById(long id) {

		Course course = entitymanager.find(Course.class, id);
		entitymanager.remove(course);
	}
}
