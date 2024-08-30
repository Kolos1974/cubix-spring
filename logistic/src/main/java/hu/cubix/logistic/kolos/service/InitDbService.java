package hu.cubix.logistic.kolos.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.cubix.logistic.kolos.model.Address;
import hu.cubix.logistic.kolos.model.Milestone;
import hu.cubix.logistic.kolos.repository.AddressRepository;
import hu.cubix.logistic.kolos.repository.MilestoneRepository;

@Service
public class InitDbService {

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	MilestoneRepository milestoneRepository;
	
	@Transactional
	public void initDb() {
		
		
		System.out.println("Database initialized:");
		
		
		Address newAddress1 = addressRepository.save(new Address("HU", "Budapest", "Batthyany tér", "1021", "1", 111,222 ));
		System.out.println("New address Id: "+ newAddress1.getAddressId());
		
		Milestone newMilestone = new Milestone(newAddress1, LocalDateTime.of(2024,8,29, 10, 20));
		milestoneRepository.save(newMilestone);
		
		
		
	}
	
}
