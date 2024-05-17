package hu.cubix.hr.kolos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class EmployeeTLController {

	/*
	private List<AirportDto> airports = new ArrayList<>();

	// Inicializáló blokk, Java alapszolgáltatás
	{
		airports.add(new AirportDto(1, "Budapest ferenc Liszt International", "BUD"));
	}
	*/
	
	@GetMapping("/")
	public String home() {
		System.out.println("elindult");
		return "index";
	}
	
	
	
	
}
