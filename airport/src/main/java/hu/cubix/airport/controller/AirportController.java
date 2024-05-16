package hu.cubix.airport.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.cubix.airport.dto.AirportDto;

@RestController
@RequestMapping("/api/airports")
public class AirportController {
	
//	private List<AirportDto> airports = new ArrayList<>();
	private Map<Long, AirportDto> airports = new HashMap<>();

	// Inicializáló blokk, Java alapszolgáltatás
	{
//		airports.add(new AirportDto(1, "Budapest ferenc Liszt International", "BUD"));
		airports.put(1L, new AirportDto(1, "Budapest ferenc Liszt International", "BUD"));
	}
	
	
	@GetMapping
	public List<AirportDto> findAll(){
//		return airports; 
		return new ArrayList<>(airports.values()); 
	}

	@GetMapping("/{id}")
	public ResponseEntity<AirportDto> findById(@PathVariable long id) {
		AirportDto airportDto = airports.get(id);
		if(airportDto == null) {
			return ResponseEntity.notFound().build(); 
		}
		
		return ResponseEntity.ok(airportDto);
	}
	
	

	@PostMapping
//	public AirportDto create(@RequestBody AirportDto airport) {
	public ResponseEntity<AirportDto> create(@RequestBody AirportDto airport) {
//		airports.add(airport);
		if (airports.containsKey(airport.getId()))
			return ResponseEntity.badRequest().build();
		
		airports.put(airport.getId(), airport);
//		return airport;
		return ResponseEntity.ok(airport);
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<AirportDto> update(@PathVariable long id, @RequestBody AirportDto airport) {
		airport.setId(id);
		if (!airports.containsKey(id))
			return ResponseEntity.notFound().build(); 
		
		airports.put(id, airport);
		return ResponseEntity.ok(airport);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		airports.remove(id);
	}
	
	
	
	
}
