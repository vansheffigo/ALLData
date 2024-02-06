package dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.developer.employeeManager_CRUD.Entity.EmployeeEntity;

import dto.Request.EmployeeRequest;
import dto.Response.EmployeeResponse;

@Mapper
public interface EmployeeMapper {

	EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

	EmployeeEntity fromRequestToEntity(EmployeeRequest employeeRequest);

	EmployeeResponse fromEntityTOResponse(EmployeeEntity employeeEntity);
}
