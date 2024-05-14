package hu.cubix.hr.kolos;

import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.cubix.hr.kolos.model.Employee;
import hu.cubix.hr.kolos.service.EmployeeService;

@SpringBootApplication
public class HrApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hr application:");
		//10
		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "Marketing", 500000, LocalDateTime.of(2012,Month.FEBRUARY,10,10,10))));
		// 5
		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "HR", 300000, LocalDateTime.of(2018,Month.FEBRUARY,10,10,10))));
		// 2
		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "Office worker", 200000, LocalDateTime.of(2021,Month.JULY,10,10,10))));
		// 0
		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "Project Manager", 400000, LocalDateTime.of(2022,Month.FEBRUARY,10,10,10))));
	}

}
