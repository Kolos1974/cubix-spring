package hu.cubix.logistic.kolos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.logistic.kolos.model.TransportPlan;
import hu.cubix.logistic.kolos.repository.TransportPlanRepository;
import jakarta.transaction.Transactional;

@Service
public class TransportPlanService {

	@Autowired
	TransportPlanRepository transportPlanRepository;
	
	@Transactional
	public TransportPlan create(TransportPlan transportPlan)
	{
		return save(transportPlan);
	}

	@Transactional
	public TransportPlan save(TransportPlan transportPlan) {

		return transportPlanRepository.save(transportPlan);
	}

	
	public List<TransportPlan> findAll() {
		return transportPlanRepository.findAll();
	}
	
}
