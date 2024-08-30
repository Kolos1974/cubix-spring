package hu.cubix.logistic.kolos.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.cubix.logistic.kolos.dto.MilestoneDto;
import hu.cubix.logistic.kolos.model.Milestone;
import jakarta.persistence.OneToMany;

@Mapper(componentModel = "spring")
public interface MilestoneMapper {


	
	// A példa kedvéért teszek bele mapping-et
	@Mapping(target = "milestoneId", source = "milestoneId")
	@Mapping(target = "plannedTime", source = "plannedTime")
	
	// A kereszthivatkozás miatt kell kiiktatni a company alatti employee-t
	// @OneToMany(mappedBy= "company") esetén!
	// @Mapping(target = "company.employees", ignore=true)
	MilestoneDto milestoneToDto(Milestone milestone);

	@InheritInverseConfiguration
	Milestone dtoToMilestone(MilestoneDto milestoneDto);

	
	List<MilestoneDto> milestonesToDtos(List<Milestone> milestones);

	
	List<Milestone> dtosToMilestones(List<MilestoneDto> milestones);
}
