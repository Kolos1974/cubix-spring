package hu.cubix.hr.kolos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@GeneratedValue
	private Long id;
	private int registrationNumber;
	private String name;
	private String address;
	
	@OneToMany(mappedBy= "company")
	private List<Employee> employees;
	
	@ManyToOne
	private CompanyType companyType;
	

	public Company() {
	}

	public Company(Long id, int registrationNumber, String name, String address, List<Employee> employees) {
		super();
		this.id = id;
		this.registrationNumber = registrationNumber;
		this.name = name;
		this.address = address;
		this.employees = employees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return Objects.equals(id, other.id);
	}

	public List<Employee> getEmployees() {
		return employees;
	}
	
	
	// Utility metódus, két irányból beállítja a kapcsolatot!
	public void addEmployee(Employee employee) {
		employee.setCompany(this);
		if(this.employees == null)
			this.employees = new ArrayList<>();
		this.employees.add(employee);
	}
	
	

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	

}
