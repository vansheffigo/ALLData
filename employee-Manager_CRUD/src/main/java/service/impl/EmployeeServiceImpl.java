package service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.developer.employeeManager_CRUD.Entity.EmployeeEntity;

import dto.Request.EmployeeRequest;
import dto.Response.EmployeeResponse;
import dto.mapper.EmployeeMapper;
import repository.EmployeeRepository;
import service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;

	}

	@Override
	public List<EmployeeEntity> findAllEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public Optional<EmployeeEntity> findById(Long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {

		return employeeRepository.save(employeeEntity);
	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
		return employeeRepository.save(employeeEntity);
	}

	@Override
	public void deleteEmloyee(Long id) {
		employeeRepository.deleteById(id);

	}

	@Override
	public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {

		EmployeeEntity employeeEntity = EmployeeMapper.MAPPER.fromRequestToEntity(employeeRequest);

		employeeRepository.save(employeeEntity);
		return EmployeeMapper.MAPPER.fromEntityTOResponse(employeeEntity);

	}

	@Override
	public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest, Long id) {
		Optional<EmployeeEntity> checkExistingEmployee = findById(id);
		if (!checkExistingEmployee.isPresent())
			throw new RuntimeException("Employee Id" + id + "Not found");

		EmployeeEntity employeeEntity = EmployeeMapper.MAPPER.fromRequestToEntity(employeeRequest);
		employeeEntity.setId(id);
		employeeRepository.save(employeeEntity);
		return EmployeeMapper.MAPPER.fromEntityTOResponse(employeeEntity);
	}

}
