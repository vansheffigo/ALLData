package com.learningportal.LearningPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningportal.LearningPortal.Entity.AdminEntity;
import com.learningportal.LearningPortal.Entity.CoursesEntity;
import com.learningportal.LearningPortal.dto.Request.AdminRequest;
import com.learningportal.LearningPortal.dto.Request.AuthorRequest;
import com.learningportal.LearningPortal.dto.Request.CourseRequest;
import com.learningportal.LearningPortal.dto.Request.RoleRequest;
import com.learningportal.LearningPortal.dto.Response.AdminResponse;
import com.learningportal.LearningPortal.dto.Response.AuthorResponse;
import com.learningportal.LearningPortal.dto.Response.CourseResponse;
import com.learningportal.LearningPortal.dto.Response.FavoriteResponse;
import com.learningportal.LearningPortal.dto.Response.RoleResponse;
import com.learningportal.LearningPortal.service.AdminService;
import com.learningportal.LearningPortal.service.AuthorService;
import com.learningportal.LearningPortal.service.CourseService;
import com.learningportal.LearningPortal.service.FavoriteService;
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
	@Autowired
	private FavoriteService favoriteService;
//	@PostMapping
//	public UserResponse saveUser(@RequestBody UserRequest userRequest) {
//
//		return userService.saveUser(userRequest);
//	}

	@PostMapping("/Admin")
	public ResponseEntity<?> saveAdmin(@Valid @RequestBody AdminRequest adminRequest) {
		System.out.println(adminRequest);

		AdminResponse adminResponse = adminService.saveAdmin(adminRequest);
		if (adminResponse != null)
			return ResponseEntity.ok(adminResponse);
		String s = "The user already exists Please enter new creadentails";
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(s);
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

	@PostMapping("/User_id/{user_id}/Course/{course_id}/Category_name/{category_name}")
	public CourseResponse saveCourse(@PathVariable Long user_id, @PathVariable Long course_id,
			@PathVariable String category_name, @RequestBody CourseRequest courseRequest) {
		System.out.println(user_id + "     " + course_id);
		return courseService.saveCourse(user_id, course_id, category_name, courseRequest);
	}

	@GetMapping("/GetAllUsers")
	public List<AdminEntity> findAllUsers() {

		return adminService.findAllUsers();

	}

	@GetMapping("/GetAllCourses")
	public List<CoursesEntity> findAllCourses() {
		return courseService.findAllCourses();
	}

	@GetMapping("/GetAdminById")
	public ResponseEntity<?> findByEmail(@RequestBody AdminRequest adminRequest) {
		System.out.println(adminRequest.getEmail());
//		return null;
		AdminEntity adminEntity = adminService.findByEmail(adminRequest.getEmail());

		if (adminEntity != null)
			return ResponseEntity.ok(adminEntity);

		String errorMessage = "The User for this email doesn't exist" + adminRequest.getEmail();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}

	@PostMapping("/Favorites/{userId}/{courseId}")
	public FavoriteResponse Addingfavorite(@PathVariable("userId") Long userId,
			@PathVariable("courseId") Long courseId) {

		System.out.println(userId + " heelo  " + courseId);
		return favoriteService.addFavorite(userId, courseId);
	}

	@DeleteMapping("/DeleteUser")
	public void DeleteUser(@RequestBody AdminRequest adminRequest) {
		adminService.deleteuser(adminRequest.getEmail());
	}

}