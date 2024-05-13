package hu.cubix.hr.kolos.model;

import java.time.LocalDateTime;

public class Employee {

	private Long id;
	private String job;
	private Integer salary;
	private LocalDateTime startedWorking;
	
	
	public Employee(Long id, String job, Integer salary, LocalDateTime startedWorking) {
		super();
		this.id = id;
		this.job = job;
		this.salary = salary;
		this.startedWorking = startedWorking;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public Integer getSalary() {
		return salary;
	}


	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	public LocalDateTime getStartedWorking() {
		return startedWorking;
	}


	public void setStartedWorking(LocalDateTime startedWorking) {
		this.startedWorking = startedWorking;
	}
	
	
	
	
	
	
	
}
