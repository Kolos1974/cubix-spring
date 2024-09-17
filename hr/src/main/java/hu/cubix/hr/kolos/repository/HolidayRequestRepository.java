package hu.cubix.hr.kolos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import hu.cubix.hr.kolos.model.HolidayRequest;

public interface HolidayRequestRepository extends JpaRepository<HolidayRequest, Long>, JpaSpecificationExecutor<HolidayRequest> {
}
