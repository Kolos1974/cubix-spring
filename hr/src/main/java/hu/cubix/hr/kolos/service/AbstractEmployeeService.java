package hu.cubix.hr.kolos.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import hu.cubix.hr.kolos.model.Company;
import hu.cubix.hr.kolos.model.Employee;
import hu.cubix.hr.kolos.model.Position;
import hu.cubix.hr.kolos.repository.EmployeeRepository;
import hu.cubix.hr.kolos.repository.PositionRepository;
import jakarta.transaction.Transactional;

public abstract class AbstractEmployeeService implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
		
	@Autowired
	private PositionRepository positionRepository;
	
	@Override
	@Transactional
	public Employee save(Employee employee) {
		adjustPosition(employee);
				
		return employeeRepository.save(employee);
	}

	
	private void adjustPosition(Employee employee) {
		Position position = null;
		String positionName = employee.getPosition().getName();
		if(positionName != null) {
			List<Position> positions = positionRepository.findByName(positionName);
			if(positions.isEmpty()) {
				position = positionRepository.save(employee.getPosition());
			} else {
				position = positions.get(0);
			}
		}
		employee.setPosition(position);
	}



	@Override
	@Transactional
	public Employee update(Employee employee) {
		if (employeeRepository.existsById(employee.getEmployeeId())) {
			adjustPosition(employee);
			
			return employeeRepository.save(employee);
		} else
			return null;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(long id) {
		return employeeRepository.findById(id);
	}

	@Override
	@Transactional
	public void delete(long id) {
		employeeRepository.deleteById(id);
	}
	
	@Override
	public List<Employee> findEmployeesByExample(Employee example) {
		long id = example.getEmployeeId();
		String name = example.getName();
		String title = example.getPosition().getName();
		int salary = example.getSalary();
		LocalDateTime entryDate = example.getDateOfStartWork();
		Company company = example.getCompany();
		String companyName = company == null ? null : company.getName();

		Specification<Employee> spec = Specification.where(null);

		if (id > 0)
			spec = spec.and(EmployeeSpecifications.hasId(id));

		if (StringUtils.hasText(name))
			spec = spec.and(EmployeeSpecifications.hasName(name));

		if (StringUtils.hasText(title))
			spec = spec.and(EmployeeSpecifications.hasTitle(title));

		if (salary > 0)
			spec = spec.and(EmployeeSpecifications.hasSalary(salary));

		if (entryDate != null)
			spec = spec.and(EmployeeSpecifications.hasEntryDate(entryDate));

		if (StringUtils.hasText(companyName))
			spec = spec.and(EmployeeSpecifications.hasCompany(companyName));

		return employeeRepository.findAll(spec, Sort.by("employeeId"));
	}

	
}
