package hu.cubix.hr.kolos;

import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.cubix.hr.kolos.model.Employee;
import hu.cubix.hr.kolos.service.EmployeeService;
import hu.cubix.hr.kolos.service.SalaryService;
import hu.cubix.hr.kolos.service.SmartEmployeeService;

@SpringBootApplication
public class HrApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	SalaryService salaryService;	
	
	
	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hr application:");
		//10
		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "Csaba", "Marketing", 500000, LocalDateTime.of(2012,Month.FEBRUARY,10,10,10))));
		// 5
		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "Géza", "HR", 300000, LocalDateTime.of(2018,Month.FEBRUARY,10,10,10))));
		// 2
		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "Péter", "Office worker", 200000, LocalDateTime.of(2021,Month.JULY,10,10,10))));
		// 0
		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "Pál", "Project Manager", 400000, LocalDateTime.of(2022,Month.FEBRUARY,10,10,10))));
		
		///////////
		Employee emp1 = new Employee((long) 1, "Csaba", "Marketing", 500000, LocalDateTime.of(2012,Month.FEBRUARY,10,10,10));
		Employee emp2 = new Employee((long) 1, "Géza", "HR", 300000, LocalDateTime.of(2018,Month.FEBRUARY,10,10,10));
		Employee emp3 = new Employee((long) 1, "Péter", "Office worker", 200000, LocalDateTime.of(2021,Month.JULY,10,10,10));
		Employee emp4 = new Employee((long) 1, "Pál", "Project Manager", 400000, LocalDateTime.of(2022,Month.FEBRUARY,10,10,10));
		
		
		
		System.out.println("Origin salary:");
		System.out.println(emp1.getSalary());		
		System.out.println(emp2.getSalary());		
		System.out.println(emp3.getSalary());		
		System.out.println(emp4.getSalary());		
		
		salaryService.setNewSalary(emp1);
		salaryService.setNewSalary(emp2);
		salaryService.setNewSalary(emp3);
		salaryService.setNewSalary(emp4);
		
		System.out.println("Changed salary:");
		System.out.println(emp1.getSalary());		
		System.out.println(emp2.getSalary());		
		System.out.println(emp3.getSalary());		
		System.out.println(emp4.getSalary());		
		
		
	}

}
