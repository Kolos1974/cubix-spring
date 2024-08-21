package hu.cubix.logistic.kolos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.cubix.logistic.kolos.model.TransportPlan;

public interface TransportPlanRepository extends JpaRepository<TransportPlan,Long> {

	
}
