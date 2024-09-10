package hu.cubix.hr.kolos.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import hu.cubix.hr.kolos.dto.CompanyDto;
import hu.cubix.hr.kolos.dto.EmployeeDto;
import hu.cubix.hr.kolos.mapper.CompanyMapper;
import hu.cubix.hr.kolos.model.AverageSalaryByPosition;
import hu.cubix.hr.kolos.model.Company;
import hu.cubix.hr.kolos.repository.CompanyRepository;
import hu.cubix.hr.kolos.service.CompanyService;
import hu.cubix.hr.kolos.service.SalaryService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CompanyMapper companyMapper;

	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	SalaryService salaryService;
	
	private Map<Long, CompanyDto> companies = new HashMap<>();
	
	/*
	@GetMapping
	public List<CompanyDto> findAll(){
			// return companies.values().stream().toList();
			return new ArrayList<>(companies.values()); 
	}
	*/
		
	
	
	//1. megoldás
	@GetMapping
	public List<CompanyDto> findAll(@RequestParam Optional<Boolean> full){
	
//		if(full.orElse(false)) {
//			return new ArrayList<>(companies.values());
//		} else {
//			return companies.values().stream()
//			.map(this::createCompanyWithoutEmployees)
//			.toList();
//		}
		
		List<Company> companies = companyService.findAll();
		if(full.orElse(false)) {
			return companyMapper.companiesToDtos(companies);
		} else {
			return companyMapper.companiesToSummaryDtos(companies);
		}
	}
	

	//2. megoldás @JsonView-val
//	@GetMapping(params="full=true")
//	public List<CompanyDto> findAll(){		
//		return new ArrayList<>(companies.values());
//	}
//	
//	@GetMapping
//	@JsonView(Views.BaseData.class)
//	public List<CompanyDto> findAllWithoutEmployees(){		
//		return new ArrayList<>(companies.values());
//	}
	
	
	
//	private CompanyDto createCompanyWithoutEmployees(CompanyDto c) {
//		return new CompanyDto(c.getId(), c.getRegNumber(), c.getName(), c.getAddress(), null);
//	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<CompanyDto> findById(@PathVariable long id, @RequestParam Optional<Boolean> full) {
		
//		CompanyDto companyDto = companies.get(id);
//		if(companyDto == null) {
//			return ResponseEntity.notFound().build();
//		}
//		
//		return ResponseEntity.ok(
//				full.orElse(false) ? 
//				companyDto
//				: createCompanyWithoutEmployees(companyDto)
//			);
		
		Company company = companyService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return ResponseEntity.ok(
				full.orElse(false) ? 
				companyMapper.companyToDto(company)
				: companyMapper.companyToSummaryDto(company)
			);		
		
	}
	
	
	/*
	@GetMapping("/{id}")
	public ResponseEntity<CompanyDto> findById(@PathVariable long id) {
		CompanyDto companyDto = companies.get(id);
		if(companyDto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(companyDto);
	}
	*/
	
	
	
	@PostMapping
//	public ResponseEntity<CompanyDto> create(@RequestBody CompanyDto company) {
		public CompanyDto create(@RequestBody CompanyDto companyDto) {
		
//		if(companies.containsKey(company.getId()))
//			return ResponseEntity.badRequest().build();
//			
//		companies.put(company.getId(), company);
//		return ResponseEntity.ok(company);
		
		return companyMapper.companyToDto(companyService.save(companyMapper.dtoToCompany(companyDto)));
		
	}
	
	
	@PutMapping("/{id}")
//	public ResponseEntity<CompanyDto> update(@PathVariable long id, @RequestBody CompanyDto company) {
	public CompanyDto update(@PathVariable long id, @RequestBody CompanyDto companyDto) {
		
//		company.setId(id);
//		if(!companies.containsKey(id))
//			return ResponseEntity.notFound().build();
//		
//		companies.put(id, company);
//		return ResponseEntity.ok(company);
		
		companyDto.setId(id);
		Company updatedCompany = companyService.update(companyMapper.dtoToCompany(companyDto));
		if (updatedCompany == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return companyMapper.companyToDto(updatedCompany);  
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
//		companies.remove(id);
		companyService.delete(id);
	}
	
	@PostMapping("/{id}/employees_old")
	public ResponseEntity<CompanyDto> addNewEmployee_old(@PathVariable long id, @RequestBody EmployeeDto employeeDto){
		CompanyDto companyDto = companies.get(id);
		if (companyDto == null)
			return ResponseEntity.notFound().build();
		
		companyDto.getEmployees().add(employeeDto);
		return ResponseEntity.ok(companyDto);
	}

	
	@PostMapping("/{id}/employees")
	public CompanyDto addNewEmployee(@PathVariable long id, @RequestBody EmployeeDto employeeDto){
//		CompanyDto companyDto = getCompanyByIdOrThrow(id);
//		
//		companyDto.getEmployees().add(employeeDto);
//		return companyDto;
		
		Company company = companyService.addEmployee(id, companyMapper.dtoToEmployee(employeeDto));
		return companyMapper.companyToDto(company);		
	}
	
	
	@DeleteMapping("/{id}/employees/{employeeId}")
	public CompanyDto deleteEmployee(@PathVariable long id, @PathVariable long employeeId){
		
//		CompanyDto companyDto = getCompanyByIdOrThrow(id);
//		companyDto.getEmployees().removeIf(e -> e.getId() == employeeId);
//		return companyDto;
		
		Company company = companyService.deleteEmployee(id, employeeId);
		return companyMapper.companyToDto(company);		
	}
	
	
	@PutMapping("/{id}/employees")
	public CompanyDto replaceEmployees(@PathVariable long id, @RequestBody List<EmployeeDto> newEmployees){
		
//		CompanyDto companyDto = getCompanyByIdOrThrow(id);
//		companyDto.setEmployees(newEmployees);
//		return companyDto

		Company company = companyService.replaceEmployees(id, companyMapper.dtosToEmployees(newEmployees));
		return companyMapper.companyToDto(company);
	}
	
	
	
	@GetMapping(params = "aboveSalary")
	public List<CompanyDto> getCompaniesAboveSalary(@RequestParam int aboveSalary,
			@RequestParam Optional<Boolean> full) {
		List<Company> filteredCompanies = companyRepository.findByEmployeeWithSalaryHigherThan(aboveSalary);
		return mapCompanies(filteredCompanies, full);
	}

	@GetMapping(params = "aboveEmployeeCount")
	public List<CompanyDto> getCompaniesAboveEmployeeCount(@RequestParam int aboveEmployeeCount,
			@RequestParam Optional<Boolean> full) {
		List<Company> filteredCompanies = companyRepository.findByEmployeeCountHigherThan(aboveEmployeeCount);
		return mapCompanies(filteredCompanies, full);
	}

	@GetMapping("/{id}/salaryStats")
	public List<AverageSalaryByPosition> getSalaryStatsById(@PathVariable long id) {
		return companyRepository.findAverageSalariesByPosition(id);
	}
	
	
	@PutMapping("/{id}/raiseMinSalary/{positionName}/{minSalary}")
	public void raiseMinSalary(@PathVariable long id, @PathVariable String positionName, @PathVariable int minSalary) {
		salaryService.raiseMinSalary(id, positionName, minSalary);
	}
	

	private List<CompanyDto> mapCompanies(List<Company> companies, Optional<Boolean> full) {
		if (full.orElse(false)) {
			return companyMapper.companiesToDtos(companies);
		} else {
			return companyMapper.companiesToSummaryDtos(companies);
		}
	}	
	
	
	
//	private CompanyDto getCompanyByIdOrThrow(long id) {
//		CompanyDto companyDto = companies.get(id);
//		if(companyDto == null)
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		return companyDto;
//	}
	
	
	
}
