package hu.cubix.hr.kolos.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hu.cubix.hr.kolos.dto.EmployeeDto;
import hu.cubix.hr.kolos.model.Employee;

@Controller
public class EmployeeTLController {

	private List<EmployeeDto> allEmployees = new ArrayList<>();

	{
		allEmployees
				.add(new EmployeeDto(1L, "Kis Gábor", "osztályvezető", 100000, LocalDateTime.of(2012, 1, 1, 8, 0, 0)));
	}

	
	@GetMapping("/")
	public String home() {
		return "index";
	}

	/*
	 * @GetMapping("/") public String home(Map<String, Object> model) {
	 * model.put("employees", allEmployees); //model.put("newEmployee", new
	 * EmployeeDto()); return "index"; }
	 */

	/*
	 * @GetMapping("/employees") public String listEmployees(Map<String, Object>
	 * model) { model.put("employees", allEmployees); model.put("newEmployee", new
	 * EmployeeDto()); return "employees"; }
	 */

	@GetMapping("/employees")
	public String listEmployees(Map<String, Object> model) {
		model.put("employees", allEmployees);
		model.put("newEmployee", new Employee());
		return "employees";
	}

	@PostMapping("/employees")
	public String addEmployee(EmployeeDto employee) {
		allEmployees.add(employee);
		return "redirect:employees";
	}

}
