package com.learningportal.LearningPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningportal.LearningPortal.dto.Request.AdminRequest;
import com.learningportal.LearningPortal.dto.Request.AuthorRequest;
import com.learningportal.LearningPortal.dto.Request.CourseRequest;
import com.learningportal.LearningPortal.dto.Request.RoleRequest;
import com.learningportal.LearningPortal.dto.Response.AdminResponse;
import com.learningportal.LearningPortal.dto.Response.AuthorResponse;
import com.learningportal.LearningPortal.dto.Response.CourseResponse;
import com.learningportal.LearningPortal.dto.Response.RoleResponse;
import com.learningportal.LearningPortal.service.AdminService;
import com.learningportal.LearningPortal.service.AuthorService;
import com.learningportal.LearningPortal.service.CourseService;
import com.learningportal.LearningPortal.service.RoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/learningportal")
public class UserController {
//	@Autowired
//	private UserService userService;
//
	@Autowired
	private RoleService roleService;

	@Autowired
	private AdminService adminService;
	@Autowired
	private AuthorService authorService;

	@Autowired
	private CourseService courseService;

//	@PostMapping
//	public UserResponse saveUser(@RequestBody UserRequest userRequest) {
//
//		return userService.saveUser(userRequest);
//	}

	@PostMapping("/Admin")
	public AdminResponse saveAdmin(@Valid @RequestBody AdminRequest adminRequest) {
		System.out.println(adminRequest);

		return adminService.saveAdmin(adminRequest);
	}

	@PostMapping("/Role/{id}")
	public RoleResponse saveRole(@Valid @RequestBody RoleRequest roleRequest) {

		return roleService.saveRole(roleRequest);
	}

	@PostMapping("/Author")
	public AuthorResponse saveAuthor(@RequestBody AuthorRequest authorRequest) {
		System.out.println(authorRequest);
		return authorService.saveAuthor(authorRequest);
	}

//	@PostMapping("/Course/{id}")
//	public EnrollmentResponse savEnrollment(@RequestBody EnrollmentRequest enrollmentRequest)
//	{
//		return Enrol
//	}

	@PostMapping("/User_id/{user_id}/Course/{course_id}")
	public CourseResponse saveCourse(@PathVariable Long user_id, @PathVariable Long course_id,
			@RequestBody CourseRequest courseRequest) {
		System.out.println(user_id + "     " + course_id);
		return courseService.saveCourse(user_id, course_id, courseRequest);
	}

}