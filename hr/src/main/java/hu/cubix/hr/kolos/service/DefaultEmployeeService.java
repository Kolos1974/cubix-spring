package hu.cubix.hr.kolos.service;

import org.springframework.stereotype.Service;

import hu.cubix.hr.kolos.model.Employee;

// @Service
public class DefaultEmployeeService implements EmployeeService {

	@Override
	public int getPayRaisePercent(Employee employee) {
		return 5;
	}
	

}
