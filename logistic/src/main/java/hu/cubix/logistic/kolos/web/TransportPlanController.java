package hu.cubix.logistic.kolos.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.cubix.logistic.kolos.dto.TransportPlanDto;
import hu.cubix.logistic.kolos.mapper.TransportPlanMapper;
import hu.cubix.logistic.kolos.model.TransportPlan;
import hu.cubix.logistic.kolos.service.TransportPlanService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/transportPlans")
public class TransportPlanController {

	
	@Autowired
	TransportPlanService transportPlanService;
	
	@Autowired
	TransportPlanMapper transportPlanMapper;
	
	
	@PostMapping
	public ResponseEntity<Long> addTransportPlan(@RequestBody @Valid TransportPlanDto transportPlanDto)
	{
		TransportPlan transportPlan = transportPlanMapper.dtoToTransportPlan(transportPlanDto);

		if(transportPlan == null || transportPlan.getTransportPlanId() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		TransportPlan newTransportPlan = transportPlanService.create(transportPlan);
		
		// Teszt
		System.out.println("TP Id:"+ newTransportPlan.getTransportPlanId());
		
		return ResponseEntity.ok(newTransportPlan.getTransportPlanId());
	}
	
	
	@GetMapping
	public List<TransportPlanDto> findAll(){
		List<TransportPlan> transportPlans = null;
		transportPlans = transportPlanService.findAll();
		return transportPlanMapper.transportPlansToDtos(transportPlans);
	}
	
	
}

