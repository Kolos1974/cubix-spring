package hu.cubix.hr.kolos.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import hu.cubix.hr.kolos.dto.CompanyDto;
import hu.cubix.hr.kolos.dto.EmployeeDto;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
	
	
	private Map<Long, CompanyDto> companies = new HashMap<>();
	
	
	@GetMapping
	public List<CompanyDto> findAll(){
			return companies.values().stream().toList();
	}
		

	@GetMapping("/{id}")
	public ResponseEntity<CompanyDto> findById(@PathVariable long id) {
		CompanyDto companyDto = companies.get(id);
		if(companyDto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(companyDto);
	}
	
	@PostMapping
	public ResponseEntity<CompanyDto> create(@RequestBody CompanyDto company) {
		if(companies.containsKey(company.getId()))
			return ResponseEntity.badRequest().build();
			
		companies.put(company.getId(), company);
		return ResponseEntity.ok(company);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<CompanyDto> update(@PathVariable long id, @RequestBody CompanyDto company) {
		company.setId(id);
		if(!companies.containsKey(id))
			return ResponseEntity.notFound().build();
		
		companies.put(id, company);
		return ResponseEntity.ok(company);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		companies.remove(id);
	}
	
	

}
