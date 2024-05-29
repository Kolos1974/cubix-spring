package hu.cubix.hr.kolos.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

public class CompanyDto {
	
	@JsonView(Views.BaseData.class)
	private long id;
	@JsonView(Views.BaseData.class)
	private String regNumber;
	@JsonView(Views.BaseData.class)
	private String name;
	@JsonView(Views.BaseData.class)
	private String address;
		
	private List<EmployeeDto> employees = new ArrayList<>();

	public CompanyDto(long id, String regNumber, String name, String address, List<EmployeeDto> employees) {
		super();
		this.id = id;
		this.regNumber = regNumber;
		this.name = name;
		this.address = address;
		this.employees = employees;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<EmployeeDto> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDto> employees) {
		this.employees = employees;
	}
	
	
	
	
}
