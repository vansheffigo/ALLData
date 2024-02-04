package com.example.jpahibernatepractice.jpahibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.jpahibernatepractice.jpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
//	@Autowired
//	private CourseJdbcRepository repository;

//	@Autowired
//	private CourseJpaRepositary repository;

	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Course(1, "Learn AWS", "in28minutes"));
		repository.save(new Course(2, "Learn AWS learn", "in28minutes"));
		repository.save(new Course(3, "Learn Azure", "in28minutes"));
		repository.deleteById(1l);

		System.out.println(repository.findById(3l));
		System.out.println(repository.findById(2l));
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		System.out.println(repository.findByAuthor("in28minutes"));
	}

}
