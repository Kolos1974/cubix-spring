package hu.cubix.hr.kolos.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hu.cubix.hr.kolos.model.Employee;

@Controller
public class EmployeeTLController {

	//private List<EmployeeDto> allEmployees = new ArrayList<>();
	private List<Employee> allEmployees = new ArrayList<>();

	{
		allEmployees
				.add(new Employee(1L, "Kis Gábor", "osztályvezető", 100000, LocalDateTime.of(2012, 1, 1, 8, 0, 0)));
		allEmployees
				.add(new Employee(2L, "Papp Ignác", "igazgató", 500000, LocalDateTime.of(2014, 5, 6, 8, 0, 0)));
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

    @GetMapping("/employees/modify")
    public String modifyEmployees(Map<String,Object> model){
        model.put("employees",allEmployees);
        model.put("newEmployee",new Employee());
        return "employee";
    }

    @GetMapping("/employees/modify/{id}")
    public String modifyEmployees(@PathVariable("id") long id, Map<String,Object> model){
        Employee employee=allEmployees.stream().filter(e->e.getEmployeeId()==id).findFirst().get();
        model.put("employees",allEmployees);
        model.put("modifiedEmployee",employee);
        return "employee";
    }

    @PostMapping("/employees")
	//public String addEmployee(EmployeeDto employee) {
	public String addEmployee(Employee employee) {
		allEmployees.add(employee);
		return "redirect:employees";
	}

    
    @PostMapping("/employees/updateEmployee")
    public String updateEmployees(Employee employee){
        for (int i = 0; i < allEmployees.size(); i++) {
            if(allEmployees.get(i).getEmployeeId()== employee.getEmployeeId()){
                allEmployees.set(i,employee);
            }
        }
        return "redirect:/employees";
    }

    @GetMapping("/employees/delete/{id}")
    public String deleteEmployees(@PathVariable("id") long id){
        List<Employee> result=
        allEmployees.stream().filter(employee->employee.getEmployeeId()==id).toList();
        allEmployees.removeAll(result);
        return "redirect:/employees";
    }
    
    
}
