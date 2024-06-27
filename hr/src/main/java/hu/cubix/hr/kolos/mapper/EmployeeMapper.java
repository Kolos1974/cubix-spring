
package hu.cubix.hr.kolos.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.cubix.hr.kolos.dto.EmployeeDto;
import hu.cubix.hr.kolos.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

	List<EmployeeDto> employeesToDtos(List<Employee> employees);

	EmployeeDto employeeToDto(Employee employee);

	Employee dtoToEmployee(EmployeeDto employeeDto);

	List<Employee> dtosToEmployees(List<EmployeeDto> employees);

}