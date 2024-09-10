package hu.cubix.hr.kolos.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import hu.cubix.hr.kolos.model.Employee;
import hu.cubix.hr.kolos.repository.EmployeeRepository;
import hu.cubix.hr.kolos.repository.PositionDetailsByCompanyRepository;
import hu.cubix.hr.kolos.repository.PositionRepository;
import jakarta.transaction.Transactional;

@Service
public class SalaryService {

	private EmployeeService employeeService;

	/*
	 * public SalaryService(EmployeeService employeeService) { // super();
	 * this.employeeService = employeeService; }
	 */

	private PositionRepository positionRepository;
	private PositionDetailsByCompanyRepository positionDetailsByCompanyRepository;
	private EmployeeRepository employeeRepository;

	/*
	public SalaryService(EmployeeService employeeService, PositionRepository positionRepository,
			PositionDetailsByCompanyRepository positionDetailsByCompanyRepository,
			EmployeeRepository employeeRepository) {
		this.employeeService = employeeService;
	}
	*/
	
    // Itt konstrukto injektálás van!!	
	public SalaryService(EmployeeService employeeService, PositionRepository positionRepository,
			PositionDetailsByCompanyRepository positionDetailsByCompanyRepository,
			EmployeeRepository employeeRepository) {
		super();
		this.employeeService = employeeService;
		this.positionRepository = positionRepository;
		this.positionDetailsByCompanyRepository = positionDetailsByCompanyRepository;
		this.employeeRepository = employeeRepository;
	}

	public void setNewSalary(Employee employee) {
		employee.setSalary((int) (employee.getSalary() * (100.0 + employeeService.getPayRaisePercent(employee)) / 100));
	}


	@Transactional
	public void raiseMinSalary(long companyId, String positionName, int minSalary) {
		positionDetailsByCompanyRepository
		.findByPositionNameAndCompanyId(positionName, companyId)
		.forEach(pd -> pd.setMinSalary(minSalary));
		
		//1. megoldás: nem hatékony: a cég összes alkalmazottját betöltjük, és a módosítottakat
		//egyesével fogja a JPA SQL UPDATE-tel visszamenteni 
//		pd.getCompany().getEmployees().forEach(e -> {
//			if(e.getPosition().getName().equals(positionName) && e.getSalary() < minSalary)
//				e.setSalary(minSalary);
//		});
		
		//2. megoldás
		employeeRepository.updateSalaries(companyId, positionName, minSalary);
	}
	
}
