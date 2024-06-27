package hu.cubix.hr.kolos.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.cubix.hr.kolos.dto.EmployeeDto;
import hu.cubix.hr.kolos.mapper.EmployeeMapper;
import hu.cubix.hr.kolos.model.Employee;
import hu.cubix.hr.kolos.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
//	private Map<Long, EmployeeDto> employees = new HashMap<>();
	
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@GetMapping
	public List<EmployeeDto> findAll(@RequestParam Optional<Integer> minSalary){
//		if(minSalary.isEmpty())
//			return new ArrayList<>(employees.values());
//		else
//			return employees.values().stream().filter(e -> e.getSalary() > minSalary.get()).toList();
		
		List<Employee> employees = null;
		if (minSalary.isPresent()) {
			// employees = employeeRepository.findBySalaryGreaterThan(minSalary);
		} else {
			employees = employeeService.findAll();
		}
		return employeeMapper.employeesToDtos(employees);
		
		
	}
	
	
	//1. megoldás a minSalary szerinti szűrésre
//	@GetMapping(params = "minSalary")
//	public List<EmployeeDto> findByMinSalary(@RequestParam int minSalary){
//		return employees.values().stream().filter(e -> e.getSalary() > minSalary).toList();
//	}
	
	@GetMapping("/{id}")
//	public ResponseEntity<EmployeeDto> findById(@PathVariable long id) {
//		EmployeeDto employeeDto = employees.get(id);
//		if(employeeDto == null) {
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok(employeeDto);
//	}
	public EmployeeDto findById(@PathVariable long id) {
		Employee employee = findByIdOrThrow(id);
		return employeeMapper.employeeToDto(employee);
	}

	
	private Employee findByIdOrThrow(long id) {
		return employeeService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));	
	}
	
	
	
	
	@PostMapping
//	public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employee) {
//		if(employees.containsKey(employee.getId()))
//			return ResponseEntity.badRequest().build();
//			
//		employees.put(employee.getId(), employee);
//		return ResponseEntity.ok(employee);
//	}
	public EmployeeDto create(@RequestBody EmployeeDto employeeDto) {
		return employeeMapper.employeeToDto(employeeService.save(employeeMapper.dtoToEmployee(employeeDto)));
	}
	

	
	
	@PutMapping("/{id}")
//	public ResponseEntity<EmployeeDto> update(@PathVariable long id, @RequestBody EmployeeDto employee) {
//		employee.setId(id);
//		if(!employees.containsKey(id))
//			return ResponseEntity.notFound().build();
//		
//		employees.put(id, employee);
//		return ResponseEntity.ok(employee);
//	}
	public ResponseEntity<EmployeeDto> update(@PathVariable long id, @RequestBody EmployeeDto employeeDto) {
		employeeDto.setId(id);
		Employee updatedEmployee = employeeService.update(employeeMapper.dtoToEmployee(employeeDto));
		if (updatedEmployee == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(employeeMapper.employeeToDto(updatedEmployee));
		}
	}
	
	
	
	
	@DeleteMapping("/{id}")
//	public void delete(@PathVariable long id) {
//		employees.remove(id);
//	}
	public void delete(@PathVariable long id) {
		employeeService.delete(id);
	}
	
	
	
	@PostMapping("/payraise")
	public int getPayRaisePercent(@RequestBody Employee employee) {
		
		return employeeService.getPayRaisePercent(employee);
	}
	
	
}
