package hu.cubix.hr.kolos.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import hu.cubix.hr.kolos.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	// A metódusnévből ki tudja találni, hogy milyen query-t kell készítenie!!
	List<Employee> findBySalaryGreaterThan(Integer minSalary);

	List<Employee> findByPositionName(String title);
	
	List<Employee> findByNameStartingWithIgnoreCase(String name);
	
	
	// JPQL-el lehet konkrét Query-t írni:
	// @Query("SELECT e FROM Employee e WHERE e.dateOfStartWork <= :end AND e.dateOfStartWork >= :start")
	List<Employee> findByDateOfStartWorkBetween(LocalDateTime start, LocalDateTime end);
	
	@Query("UPDATE Employee e "
			+ "SET e.salary = :minSalary "
			+ "WHERE e.company.id=:companyId "
			+ "AND e.position.name = :positionName "
			+ "AND e.salary < :minSalary")
	@Modifying	
	void updateSalaries(long companyId, String positionName, int minSalary);
	
	
	
}
