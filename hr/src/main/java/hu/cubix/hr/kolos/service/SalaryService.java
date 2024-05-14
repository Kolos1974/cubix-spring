package hu.cubix.hr.kolos.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import hu.cubix.hr.kolos.model.Employee;

@Service
public class SalaryService {

	private EmployeeService employeeService;

	public SalaryService(EmployeeService employeeService) {
		// super();
		this.employeeService = employeeService;
	}
	

	public void setNewSalary(Employee employee) {
		employee.setSalary((int)(employee.getSalary()*(100.0 + employeeService.getPayRaisePercent(employee))/100));
	}


}
