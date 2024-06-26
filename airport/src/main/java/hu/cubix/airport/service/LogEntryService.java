package hu.cubix.airport.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.airport.model.Airport;
import hu.cubix.airport.model.LogEntry;
import hu.cubix.airport.repository.LogEntryRepository;

@Service
public class LogEntryService {

	@Autowired
	private LogEntryRepository logEntryRepository;
	
	
	
	public void logAirportChange(Airport airport) {
		int dataFromOtherBackend = callOtherBackendSystem();
		logEntryRepository.save(new LogEntry(
				String.format("Airport with id %d was modified. New name is %s. Data from other backend is %d.", 
						airport.getId(),
						airport.getName(),
						dataFromOtherBackend)));
	}
	

	
	// Ezzel szimuláljuk, hogy egy másik rendszerből is kapnunk kellene adat-ot.
	public int callOtherBackendSystem() {
		int random = new Random().nextInt(4);
		if(random == 0) {
			throw new RuntimeException();
		}
		return random;
	}
	
			
			
}
