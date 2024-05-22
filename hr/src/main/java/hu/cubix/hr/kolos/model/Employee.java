package hu.cubix.hr.kolos.model;

import java.time.LocalDateTime;

public class Employee {

	private Long employeeId;
	private String jobTitle;
	private Integer salary;
	private LocalDateTime dateOfStartWork;
	
	public Employee() {
	}
		
	public Employee(Long employeeId, String jobTitle, Integer salary, LocalDateTime dateOfStartWork) {
		super();
		this.employeeId = employeeId;
		this.jobTitle = jobTitle;
		this.salary = salary;
		this.dateOfStartWork = dateOfStartWork;
	}


	public Long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public Integer getSalary() {
		return salary;
	}


	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	public LocalDateTime getDateOfStartWork() {
		return dateOfStartWork;
	}


	public void setDateOfStartWork(LocalDateTime dateOfStartWork) {
		this.dateOfStartWork = dateOfStartWork;
	}
	
	
	
	
	
	
	
}
