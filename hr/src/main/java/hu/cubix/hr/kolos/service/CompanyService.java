package hu.cubix.hr.kolos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.hr.kolos.model.Company;
import hu.cubix.hr.kolos.model.Employee;
import hu.cubix.hr.kolos.repository.CompanyRepository;
import jakarta.transaction.Transactional;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private EmployeeService employeeService;
	
	// @Override
	public Company save(Company company) {
		return companyRepository.save(company);
	}

	// @Override
	public Company update(Company company) {
		if (companyRepository.existsById(company.getId()))
			return companyRepository.save(company);
		else
			return null;
	}

	// @Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	// @Override
	public Optional<Company> findById(long id) {
		return companyRepository.findById(id);
	}

	// @Override
	public void delete(long id) {
		companyRepository.deleteById(id);
	}
	
	public Company addEmployee(long id, Employee employee) {
		Company company = companyRepository.findById(id).get();
		company.addEmployee(employee);
		employeeService.save(employee);
		
		// Ez azért nem szükséges, mert az idegen kulcs az employee táblában van!
		//companyRepository.save(company);
		
		return company;
	}
	
	public Company deleteEmployee(long id, long employeeId) {
		Company company = companyRepository.findById(id).get();
		Employee employee = employeeService.findById(employeeId).get();
		employee.setCompany(null);
		company.getEmployees().remove(employee);
		employeeService.save(employee);
		return company;
	}
	
	@Transactional
	public Company replaceEmployees(long id, List<Employee> employees) {
		Company company = companyRepository.findById(id).get();
		company.getEmployees().forEach(e -> {
			e.setCompany(null);
		});
		company.getEmployees().clear();
		
		employees.forEach(e -> {
			// company.addEmployee(e);
			// employeeService.save(e);
			Employee savedEmployee = employeeService.save(e);

			// Itt már megvan az Employee kapott id-je!!
			// System.out.println(savedEmployee.getEmployeeId());
			
			company.addEmployee(savedEmployee);
		});
		
		return company;
	}
	
	
	
}
