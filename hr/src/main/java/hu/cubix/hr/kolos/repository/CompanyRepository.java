package hu.cubix.hr.kolos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.cubix.hr.kolos.model.AverageSalaryByPosition;
import hu.cubix.hr.kolos.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	@Query("SELECT DISTINCT c FROM Company c JOIN c.employees e WHERE e.salary > :minSalary")
	public List<Company> findByEmployeeWithSalaryHigherThan(int minSalary);
	
	@Query("SELECT c FROM Company c WHERE SIZE(c.employees) > :minEmployeeCount")
	public List<Company> findByEmployeeCountHigherThan(int minEmployeeCount);

	
	/*
	@Query("SELECT e.position.name AS position, AVG(e.salary) AS averageSalary "
			+ "FROM Company c "
			+ "JOIN c.employees e "
			+ "WHERE c.id=:companyId "
			+ "GROUP BY e.position.name "
			+ "ORDER BY AVG(e.salary) DESC")
	public List<AverageSalaryByPosition> findAverageSalariesByPosition(long companyId);
	*/
		
	
	
}
