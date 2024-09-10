package hu.cubix.hr.kolos.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import hu.cubix.hr.kolos.dto.CompanyDto;
import hu.cubix.hr.kolos.dto.EmployeeDto;
import hu.cubix.hr.kolos.model.Company;
import hu.cubix.hr.kolos.model.Employee;

// @Mapper(componentModel = "spring", uses = CustomMapper.class)
@Mapper(componentModel = "spring")
public interface CompanyMapper {

	// Ez a saját elnevezés miatt!
	@Mapping(target = "regNumber", source = "registrationNumber")
	CompanyDto companyToDto(Company company);

	// Ez a saját elnevezés miatt!
//	@Mapping(target = "regNumber", source = "registrationNumber", qualifiedByName = "intToString")
	@Mapping(target = "regNumber", source = "registrationNumber")
	List<CompanyDto> companiesToDtos(List<Company> companies);

	// Ez a saját elnevezés miatt!
	// @InheritInverseConfiguration
	@Mapping(target = "registrationNumber", source = "regNumber")
	Company dtoToCompany(CompanyDto company);
	
	
	
	// Itt is szerepel a dto-ra való konvertálás.
	// Azért van ez a duplikáció, mert lehet, hogy itt máshogy akarnánk a konvertálást elvégezni. 
	@Mapping(target = "id", source = "employeeId")
	//@Mapping(target = "title", source = "jobTitle")
	@Mapping(target = "title", source = "position.name")
	@Mapping(target = "dateOfStartWork", source = "dateOfStartWork")
	// A kereszthivatkozás miatt kell kiiktatni az employee alatti company-t
	@Mapping(target = "company", ignore=true)
	EmployeeDto employeeToDto(Employee employee);

	@InheritInverseConfiguration
	Employee dtoToEmployee(EmployeeDto employeeDto);
	
	List<Employee> dtosToEmployees(List<EmployeeDto> employees);
	
	@IterableMapping(qualifiedByName = "summary")
	List<CompanyDto> companiesToSummaryDtos(List<Company> companies);
	
	@Mapping(target = "regNumber", source = "registrationNumber")
	@Mapping(target = "employees", ignore = true)
	@Named("summary")
	CompanyDto companyToSummaryDto(Company company);
}
