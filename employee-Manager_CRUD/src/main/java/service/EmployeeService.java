package service;

import java.util.List;
import java.util.Optional;

import com.developer.employeeManager_CRUD.Entity.EmployeeEntity;

import dto.Request.EmployeeRequest;
import dto.Response.EmployeeResponse;

public interface EmployeeService {

	List<EmployeeEntity> findAllEmployee();

	Optional<EmployeeEntity> findById(Long id);

	EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);

	EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);

	void deleteEmloyee(Long id);

	EmployeeResponse saveEmployee(EmployeeRequest employeeRequest);

	EmployeeResponse updateEmployee(EmployeeRequest employeeRequest, Long id);
}
