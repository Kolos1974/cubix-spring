package hu.cubix.hr.kolos.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.hr.kolos.config.HrConfigurationProperties;
import hu.cubix.hr.kolos.model.Employee;

@Service
public class SmartEmployeeService implements EmployeeService {

	@Autowired
	HrConfigurationProperties config;
	
	@Override
	public int getPayRaisePercent(Employee employee) {

		// Older version:
		/*
		if (LocalDate.now().getYear()-employee.getStartedWorking().getYear()>=10) {
			return 10;
		}
		if (LocalDate.now().getYear()-employee.getStartedWorking().getYear()>=5) {
			return 5;
		}
		if ((float)(LocalDate.now().getYear()-employee.getStartedWorking().getYear())>=2.5) {
			return 2;
		}
		return 0;
		*/
		
		if (LocalDate.now().getYear()-employee.getStartedWorking().getYear()>=config.getRaiseSalary().getSmartValues().getInterval1year()) {
			return config.getRaiseSalary().getSmartValues().getInterval1percent();
		}
		else if (LocalDate.now().getYear()-employee.getStartedWorking().getYear()>=config.getRaiseSalary().getSmartValues().getInterval2year()) {
			return config.getRaiseSalary().getSmartValues().getInterval2percent();
		}
		else if ((float)(LocalDate.now().getYear()-employee.getStartedWorking().getYear())>=config.getRaiseSalary().getSmartValues().getInterval3year()) {
			return config.getRaiseSalary().getSmartValues().getInterval3percent();
		}
		else return config.getRaiseSalary().getSmartValues().getInterval4percent();
		
		 
	}

}
