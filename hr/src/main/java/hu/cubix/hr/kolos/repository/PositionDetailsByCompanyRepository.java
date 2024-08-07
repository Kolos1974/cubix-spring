package hu.cubix.hr.kolos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.cubix.hr.kolos.model.PositionDetailsByCompany;

public interface PositionDetailsByCompanyRepository extends JpaRepository<PositionDetailsByCompany, Long> {

	List<PositionDetailsByCompany> findByPositionNameAndCompanyId(String positionName, long companyId);

}