package hu.cubix.logistic.kolos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.logistic.kolos.model.Address;
import hu.cubix.logistic.kolos.model.Milestone;
import hu.cubix.logistic.kolos.repository.AddressRepository;
import hu.cubix.logistic.kolos.repository.MilestoneRepository;
import jakarta.transaction.Transactional;

@Service
public class MilestoneService {

	@Autowired
	MilestoneRepository milestoneRepository;
	
	@Transactional
	public Milestone create(Milestone milestone)
	{
		return save(milestone);
	}

	@Transactional
	public Milestone save(Milestone milestone) {

		return milestoneRepository.save(milestone);
	}

	
	public List<Milestone> findAll() {
		return milestoneRepository.findAll();
	}
	
	
}
