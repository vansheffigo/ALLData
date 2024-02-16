package com.example.portal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.portal.dto.request.AddFavoriteDto;
import com.example.portal.dto.request.AdminRequest;
import com.example.portal.dto.request.AuthorRequest;
import com.example.portal.dto.request.CourseRequest;
import com.example.portal.dto.request.RoleRequest;
import com.example.portal.dto.response.AdminResponse;
import com.example.portal.dto.response.AuthorResponse;
import com.example.portal.dto.response.CourseResponse;
import com.example.portal.dto.response.FavoriteResponse;
import com.example.portal.dto.response.RoleResponse;
import com.example.portal.entity.AdminEntity;
import com.example.portal.entity.CoursesEntity;
import com.example.portal.service.AdminService;
import com.example.portal.service.AuthorService;
import com.example.portal.service.CourseService;
import com.example.portal.service.FavoriteService;
import com.example.portal.service.RoleService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/learningportal")
public class UserController {

	private final RoleService roleService;

	private final AdminService adminService;

	private final AuthorService authorService;

	private final CourseService courseService;

	private final FavoriteService favoriteService;

	public UserController(RoleService roleService, AdminService adminService, AuthorService authorService,
			CourseService courseService, FavoriteService favoriteService) {
		super();
		this.roleService = roleService;
		this.adminService = adminService;
		this.authorService = authorService;
		this.courseService = courseService;
		this.favoriteService = favoriteService;
	}

	@PostMapping("/admin")
	public ResponseEntity<?> saveAdmin(@Valid @RequestBody AdminRequest adminRequest) {
		log.info(adminRequest.toString());
		AdminResponse adminResponse = adminService.saveAdmin(adminRequest);
		if (adminResponse != null)
			return ResponseEntity.ok(adminResponse);
		String s = "The user already exists Please enter new creadentails";
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(s);
	}

	@PostMapping("/role")
	public RoleResponse saveRole(@Valid @RequestBody RoleRequest roleRequest) {

		return roleService.saveRole(roleRequest);
	}

	@PostMapping("/author")
	public AuthorResponse saveAuthor(@RequestBody AuthorRequest authorRequest) {

		return authorService.saveAuthor(authorRequest);
	}

	@PostMapping("/course")
	public CourseResponse saveCourse(@RequestBody CourseRequest courseRequest) {
		log.info(courseRequest.getCourseId().toString());
		return courseService.saveCourse(courseRequest);
	}

	@GetMapping("/getAllUsers")
	public List<AdminEntity> findAllUsers() {

		return adminService.findAllUsers();

	}

	@GetMapping("/getAllCourses")
	public List<CoursesEntity> findAllCourses() {
		return courseService.findAllCourses();
	}

	@GetMapping("/getAdminById")
	public ResponseEntity<?> findByEmail(@RequestBody AdminRequest adminRequest) {
		log.info(adminRequest.getEmail());

		AdminEntity adminEntity = adminService.findByEmail(adminRequest.getEmail());

		if (adminEntity != null)
			return ResponseEntity.ok(adminEntity);

		String errorMessage = "The User for this email doesn't exist" + adminRequest.getEmail();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}

	@PostMapping("/favorites")
	public FavoriteResponse addingfavorite(@RequestBody AddFavoriteDto addFavoriteDto) {

		return favoriteService.addFavorite(addFavoriteDto.getUserId(), addFavoriteDto.getCourseId());
	}

	@DeleteMapping("/deleteUser")
	public void deleteUser(@RequestBody AdminRequest adminRequest) {
		adminService.deleteuser(adminRequest.getEmail());
	}

	@GetMapping("/fetchCombined")
	public List<AdminEntity> fetchCombined() {

		return adminService.fetchCombined();
	}

}