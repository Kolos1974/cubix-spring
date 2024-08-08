
package hu.cubix.hr.kolos.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.cubix.hr.kolos.dto.EmployeeDto;
import hu.cubix.hr.kolos.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

	List<EmployeeDto> employeesToDtos(List<Employee> employees);

	
	@Mapping(target = "id", source = "employeeId")
	@Mapping(target = "title", source = "jobTitle")
	@Mapping(target = "dateOfStartWork", source = "dateOfStartWork")
	// A kereszthivatkozás miatt kell kiiktatni a company alatti employee-t
	@Mapping(target = "company.employees", ignore=true)
	EmployeeDto employeeToDto(Employee employee);

	@InheritInverseConfiguration
	Employee dtoToEmployee(EmployeeDto employeeDto);

	List<Employee> dtosToEmployees(List<EmployeeDto> employees);

}