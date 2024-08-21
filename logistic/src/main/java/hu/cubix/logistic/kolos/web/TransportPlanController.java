package hu.cubix.logistic.kolos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.cubix.logistic.kolos.dto.TransportPlanDto;
import hu.cubix.logistic.kolos.mapper.TransportPlanMapper;
import hu.cubix.logistic.kolos.model.TransportPlan;
import hu.cubix.logistic.kolos.service.TransportPlanService;

@RestController
@RequestMapping("/api/transportPlans")
public class TransportPlanController {

	
	@Autowired
	TransportPlanService transportPlanService;
	
	@Autowired
	TransportPlanMapper transportPlanMapper;
	
	
	@PostMapping
	public ResponseEntity<Long> addTransportPlan(@RequestBody TransportPlanDto transportPlanDto)
	{
		TransportPlan transportPlan = transportPlanMapper.dtoToTransportPlan(transportPlanDto);

		if(transportPlan == null || transportPlan.getTransportPlanId() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		TransportPlan createdTP = transportPlanService.create(transportPlan);
		return ResponseEntity.ok(createdTP.getTransportPlanId());
	}
	
	
}

