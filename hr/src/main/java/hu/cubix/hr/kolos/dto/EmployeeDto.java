package hu.cubix.hr.kolos.dto;

import java.time.LocalDateTime;

public class EmployeeDto {
	private long id;
	private String name;
	private String title;
	private int salary;
	private LocalDateTime dateOfStartWork;

	public EmployeeDto() {

	}

	public EmployeeDto(long id, String name, String title, int salary, LocalDateTime dateOfStartWork) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.salary = salary;
		this.dateOfStartWork = dateOfStartWork;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDateTime getdateOfStartWork() {
		return dateOfStartWork;
	}

	public void setdateOfStartWork(LocalDateTime dateOfStartWork) {
		this.dateOfStartWork = dateOfStartWork;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", title=" + title + ", salary=" + salary + ", dateOfStartWork="
				+ dateOfStartWork + "]";
	}

}