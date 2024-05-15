package hu.cubix.hr.kolos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.cubix.hr.kolos.service.DefaultEmployeeService;
import hu.cubix.hr.kolos.service.EmployeeService;

@Configuration
@Profile("!smart")
public class DefaultConfiguration {
	
	@Bean
	public EmployeeService employeeService() {
		return new DefaultEmployeeService(); 
	}

}
