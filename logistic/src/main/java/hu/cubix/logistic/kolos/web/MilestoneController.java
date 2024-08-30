package hu.cubix.logistic.kolos.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.cubix.logistic.kolos.dto.AddressDto;
import hu.cubix.logistic.kolos.dto.MilestoneDto;
import hu.cubix.logistic.kolos.mapper.MilestoneMapper;
import hu.cubix.logistic.kolos.model.Address;
import hu.cubix.logistic.kolos.model.Milestone;
import hu.cubix.logistic.kolos.service.MilestoneService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/milestones")
public class MilestoneController {

	@Autowired
	MilestoneService milestoneService;
	
	@Autowired
	MilestoneMapper milestoneMapper;
	

	
	@PostMapping
	public ResponseEntity<Long> addMilestone(@RequestBody @Valid MilestoneDto milestoneDto)
	{
		
		Milestone milestone = milestoneMapper.dtoToMilestone(milestoneDto);

		if(milestone == null || milestone.getMilestoneId() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		Milestone newMilestone = milestoneService.create(milestone);
		
		// Teszt
		// System.out.println("New milestone Id:"+ newMilestone.getMilestoneId());
		
		return ResponseEntity.ok(newMilestone.getMilestoneId());
	}
	
	
	@GetMapping
	public List<MilestoneDto> findAll(){
		List<Milestone> milestones = null;
		milestones = milestoneService.findAll();
		return milestoneMapper.milestonesToDtos(milestones);
	}
	
	
}
