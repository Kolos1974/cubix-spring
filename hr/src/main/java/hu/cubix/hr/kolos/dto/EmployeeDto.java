package hu.cubix.hr.kolos.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

public class EmployeeDto {
	private long id;
	@NotBlank
	private String name;
	@NotBlank
	private String title;
	@Positive
	private int salary;
	@Past
	private LocalDateTime dateOfStartWork;
	
	private CompanyDto company;
	
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

	public CompanyDto getCompany() {
		return company;
	}

	public void setCompany(CompanyDto company) {
		this.company = company;
	}

	
	
}