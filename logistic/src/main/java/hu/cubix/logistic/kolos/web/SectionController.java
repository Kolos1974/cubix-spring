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

import hu.cubix.logistic.kolos.dto.MilestoneDto;
import hu.cubix.logistic.kolos.dto.SectionDto;
import hu.cubix.logistic.kolos.mapper.MilestoneMapper;
import hu.cubix.logistic.kolos.mapper.SectionMapper;
import hu.cubix.logistic.kolos.model.Milestone;
import hu.cubix.logistic.kolos.model.Section;
import hu.cubix.logistic.kolos.service.MilestoneService;
import hu.cubix.logistic.kolos.service.SectionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sections")
public class SectionController {

	
	@Autowired
	SectionService sectionService;
	
	@Autowired
	SectionMapper sectionMapper;
	
	
	@PostMapping
	public ResponseEntity<Long> addSection(@RequestBody @Valid SectionDto sectionDto)
	{
		
		Section section = sectionMapper.dtoToSection(sectionDto);

		if(section == null || section.getSectionId() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		Section newMilestone = sectionService.create(section);
		
		// Teszt
		// System.out.println("New milestone Id:"+ newMilestone.getMilestoneId());
		
		return ResponseEntity.ok(newMilestone.getSectionId());
	}
	
	
	@GetMapping
	public List<SectionDto> findAll(){
		List<Section> sections = null;
		sections = sectionService.findAll();
		return sectionMapper.sectionsToDtos(sections);
	}
	
	
}
