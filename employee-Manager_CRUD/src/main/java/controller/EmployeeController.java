package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.employeeManager_CRUD.Entity.EmployeeEntity;

import dto.Request.EmployeeRequest;
import dto.Response.EmployeeResponse;
import service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {

		this.employeeService = employeeService;
	}

	@GetMapping
	public List<EmployeeEntity> findAllEmployee() {
		return employeeService.findAllEmployee();
	}

	@GetMapping("/{id}")
	public Optional<EmployeeEntity> findEmployeeById(@PathVariable("id") Long id) {
		return employeeService.findById(id);
	}

	@PostMapping
	public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return employeeService.saveEmployee(employeeEntity);
	}

	@PutMapping
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return employeeService.updateEmployee(employeeEntity);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmloyee(id);
	}

	// request and respose for saving and upading data
	@PostMapping("/res")
	public EmployeeResponse saveEmployeeResponse(@RequestBody EmployeeRequest employeeRequest) {
		System.out.println("hello");
		return employeeService.saveEmployee(employeeRequest);
	}

	@PutMapping("/res/{id}")
	public EmployeeResponse updateEmpResponse(@RequestBody EmployeeRequest employeeRequest,
			@PathVariable("id") Long id) {
		return employeeService.updateEmployee(employeeRequest, id);

	}
}
