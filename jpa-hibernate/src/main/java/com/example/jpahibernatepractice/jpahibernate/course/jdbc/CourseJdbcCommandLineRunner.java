package com.example.jpahibernatepractice.jpahibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
	@Autowired
	private CourseJdbcRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.insert(new Course(1, "Learn AWS", "in28minutes"));
		repository.insert(new Course(2, "Learn AWS learn", "in28minutes"));
		repository.insert(new Course(3, "Learn Azure", "in28minutes"));
		repository.deleteById(1);

	}

}
