package hu.cubix.hr.kolos.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import hu.cubix.hr.kolos.model.Employee;

@Service
public class SmartEmployeeService implements EmployeeService {

	@Override
	public int getPayRaisePercent(Employee employee) {
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
	}

}
