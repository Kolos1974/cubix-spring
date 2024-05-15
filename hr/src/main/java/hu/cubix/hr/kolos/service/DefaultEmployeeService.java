package hu.cubix.hr.kolos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.hr.kolos.config.HrConfigurationProperties;
import hu.cubix.hr.kolos.model.Employee;

 //@Service
public class DefaultEmployeeService implements EmployeeService {

	@Autowired
	HrConfigurationProperties config;
		
	
	@Override
	public int getPayRaisePercent(Employee employee) {
		// return 5;
		return config.getRaiseSalary().getDefaultValues().getPercent();
	}
	

}
