package hu.cubix.airport.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hu.cubix.airport.dto.AirportDto;
import hu.cubix.airport.model.Airport;

@Controller
public class AirportTLController {
	
	private List<Airport> airports = new ArrayList<>();

	// Inicializáló blokk, Java alapszolgáltatás
	{
		airports.add(new Airport(1, "Budapest ferenc Liszt International", "BUD"));
	}
	

	@GetMapping("/")
	public String home(Map<String, Object> model) {
		model.put("airports", airports);
		model.put("newAirport", new Airport());
		return "index";
	}
	
	
	@PostMapping("/airport")
	public String createAirport(Airport airport) {
		airports.add(airport);
		
		//model.put("airports", airports);
		//model.put("newAirport", new AirportDto());
		//return "index";
		return "redirect:/";
	}
	
}
