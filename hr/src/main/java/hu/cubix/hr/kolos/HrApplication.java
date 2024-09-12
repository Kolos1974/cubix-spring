package hu.cubix.hr.kolos;

import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.cubix.hr.kolos.config.HrConfigurationProperties;
import hu.cubix.hr.kolos.config.SmartConfiguration;
import hu.cubix.hr.kolos.model.Employee;
import hu.cubix.hr.kolos.service.EmployeeService;
import hu.cubix.hr.kolos.service.InitDbService;
import hu.cubix.hr.kolos.service.SalaryService;
import hu.cubix.hr.kolos.service.SmartEmployeeService;

@SpringBootApplication
public class HrApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	SalaryService salaryService;	
	
	
	@Autowired
	HrConfigurationProperties config;
	
	@Autowired
	InitDbService initDbService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hr application:");
		
		
		/*
		//10
//		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "Csaba", "Marketing", 500000, LocalDateTime.of(2012,Month.FEBRUARY,10,10,10))));
		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "Csaba",  500000, LocalDateTime.of(2012,Month.FEBRUARY,10,10,10))));
		// 5
//		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "Géza", "HR", 300000, LocalDateTime.of(2018,Month.FEBRUARY,10,10,10))));
		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "Géza",  300000, LocalDateTime.of(2018,Month.FEBRUARY,10,10,10))));
		// 2
//		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "Péter", "Office worker", 200000, LocalDateTime.of(2021,Month.JULY,10,10,10))));
		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "Péter",  200000, LocalDateTime.of(2021,Month.JULY,10,10,10))));
		// 0
//		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "Pál", "Project Manager", 400000, LocalDateTime.of(2022,Month.FEBRUARY,10,10,10))));
		System.out.println(employeeService.getPayRaisePercent(new Employee((long) 1, "Pál",  400000, LocalDateTime.of(2022,Month.FEBRUARY,10,10,10))));
		*/
		
		///////////
		/*
		Employee emp1 = new Employee((long) 1, "Csaba", "Marketing", 500000, LocalDateTime.of(2012,Month.FEBRUARY,10,10,10));
		Employee emp2 = new Employee((long) 1, "Géza", "HR", 300000, LocalDateTime.of(2018,Month.FEBRUARY,10,10,10));
		Employee emp3 = new Employee((long) 1, "Péter", "Office worker", 200000, LocalDateTime.of(2021,Month.JULY,10,10,10));
		Employee emp4 = new Employee((long) 1, "Pál", "Project Manager", 400000, LocalDateTime.of(2022,Month.FEBRUARY,10,10,10));
		*/
		
		/*
		Employee emp1 = new Employee((long) 1, "Csaba",  500000, LocalDateTime.of(2012,Month.FEBRUARY,10,10,10));
		Employee emp2 = new Employee((long) 1, "Géza",  300000, LocalDateTime.of(2018,Month.FEBRUARY,10,10,10));
		Employee emp3 = new Employee((long) 1, "Péter",  200000, LocalDateTime.of(2021,Month.JULY,10,10,10));
		Employee emp4 = new Employee((long) 1, "Pál",  400000, LocalDateTime.of(2022,Month.FEBRUARY,10,10,10));
		
		
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
		*/
		
		/*  Ez nem jó, de már nem is kell, az initDb() miatt!
		SmartConfiguration smartConfig = config.getSalary().getSmart();
		for (Double limit : 
				smartConfig.getLimits().keySet()
		*/
			/*Arrays.asList(smartConfig.getLimit1(), smartConfig.getLimit2(), smartConfig.getLimit3())*/
		/*
		) {

			int origSalary = 100;
			LocalDateTime limitDay = LocalDateTime.now().minusDays((long)(limit*365));
			Employee e1 = new Employee(1L, "Nagy Péter", origSalary, limitDay.plusDays(1));
			Employee e2 = new Employee(2L, "Kis Gábor", origSalary, limitDay.minusDays(1));

			salaryService.setNewSalary(e1);
			salaryService.setNewSalary(e2);

			System.out.format("1 nappal a %.2f éves határ előtt az új fizetés %d%n", limit, e1.getSalary());
			System.out.format("1 nappal a %.2f éves határ után az új fizetés %d%n", limit, e2.getSalary());
		}
		*/
		
		
		initDbService.initDb();
	}

}
