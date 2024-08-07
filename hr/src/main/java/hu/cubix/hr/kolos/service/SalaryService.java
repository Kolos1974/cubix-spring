package hu.cubix.hr.kolos.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import hu.cubix.hr.kolos.model.Employee;
import hu.cubix.hr.kolos.repository.EmployeeRepository;
import hu.cubix.hr.kolos.repository.PositionDetailsByCompanyRepository;
import hu.cubix.hr.kolos.repository.PositionRepository;

@Service
public class SalaryService {

	private EmployeeService employeeService;

	/*
	 * public SalaryService(EmployeeService employeeService) { // super();
	 * this.employeeService = employeeService; }
	 */

	private PositionRepository positionRepository;
	private PositionDetailsByCompanyRepository positionDetailsByCompanyRepository;
	private EmployeeRepository employeeRepository;

	public SalaryService(EmployeeService employeeService, PositionRepository positionRepository,
			PositionDetailsByCompanyRepository positionDetailsByCompanyRepository,
			EmployeeRepository employeeRepository) {
		this.employeeService = employeeService;
	}

	public void setNewSalary(Employee employee) {
		employee.setSalary((int) (employee.getSalary() * (100.0 + employeeService.getPayRaisePercent(employee)) / 100));
	}

}
