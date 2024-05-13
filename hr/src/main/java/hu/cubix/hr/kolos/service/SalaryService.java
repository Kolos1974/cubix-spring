package hu.cubix.hr.kolos.service;

import org.springframework.context.annotation.Bean;

import hu.cubix.hr.kolos.model.Employee;

public class SalaryService {

	//@Bean
	private EmployeeService employeeService;
	private Employee employee;

	public SalaryService(Employee employee) {
		// super();
		this.employee = employee;
	}
	

	public void setNewSalary(Employee employee) {
		employee.setSalary((int)(employee.getSalary()*(100.0 + employeeService.getPayRaisePercent(employee))/100));
	}


}
