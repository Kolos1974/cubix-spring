package hu.cubix.hr.kolos.dto;

public class CompanyDto {
	
	private long id;
	private String regNumber;
	private String name;
	private String address;
		
	private EmployeeDto employeeDto;

	public CompanyDto(long id, String regNumber, String name, String address, EmployeeDto employeeDto) {
		super();
		this.id = id;
		this.regNumber = regNumber;
		this.name = name;
		this.address = address;
		this.employeeDto = employeeDto;
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

	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}

	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}
	
	
	
	
}
