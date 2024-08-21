package hu.cubix.logistic.kolos.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InitDbService {

	
	
	@Transactional
	public void initDb() {
		
		
		System.out.println("Database initialized:");
		
	}
	
}
