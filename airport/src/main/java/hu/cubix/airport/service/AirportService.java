package hu.cubix.airport.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import hu.cubix.airport.dto.AirportDto;
import hu.cubix.airport.model.Airport;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class AirportService {

	
	// private Map<Long, Airport> airports = new HashMap<>();
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Airport create(Airport airport) {
		if(findById(airport.getId()) != null) {
			// throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			return null;
		}
		return save(airport);
	}
	
	@Transactional
	public Airport update(Airport airport) {
		if(findById(airport.getId()) == null) {
			return null;
		}
		return save(airport);
	}
	
	
	
	
	
	public Airport save(Airport airport) {
		throwIfNonUniqueIata(airport);
		// airports.put(airport.getId(), airport);
		if (airport.getId()==0) {
			em.persist(airport);
		} else {
			airport = em.merge(airport);
		}
		return airport;
	}
	
	private void throwIfNonUniqueIata(Airport airport) {
		long count = 0;
		if (airport.getId() == 0) {
			count = (long) em.createNamedQuery("Airport.countByIata")
					.setParameter("iata", airport.getIata())
					.getSingleResult();
		} else {
			count = (long) em.createNamedQuery("Airport.countByIataAndIdNot")
					.setParameter("iata", airport.getIata())
					.setParameter("id", airport.getId())
					.getSingleResult();
		}
		
//		if (airports.values().stream().anyMatch(a -> a.getIata().equals(airport.getIata())))
		if (count > 0)
			throw new NonUniqueIataException();
	}	
	
	/*
	private void throwIfNonUniqueIata(AirportDto airport) {
		if (airports.values().stream().anyMatch(a -> a.getIata().equals(airport.getIata())))
			throw new NonUniqueIataException();
	}
	*/
	
	
	public List<Airport> findAll(){
		// return new ArrayList<>(airports.values()); 
		return em.createQuery("SELECT a FROM Airport a ", Airport.class).getResultList();
		
	}
	
	public Airport findById(long id) {
		// return airports.get(id);
		return em.find(Airport.class, id);
	}
	
	@Transactional
	public void delete(long id) {
		// airports.remove(id);
		em.remove(findById(id));
		
	}
	
	
}
