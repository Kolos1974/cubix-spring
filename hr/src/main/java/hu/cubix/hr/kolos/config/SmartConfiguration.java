package hu.cubix.hr.kolos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.cubix.hr.kolos.service.DefaultEmployeeService;
import hu.cubix.hr.kolos.service.EmployeeService;
import hu.cubix.hr.kolos.service.SmartEmployeeService;

@Configuration
@Profile("smart")
public class SmartConfiguration {

	@Bean
	public EmployeeService employeeService() {
		return new SmartEmployeeService(); 
	}
}
