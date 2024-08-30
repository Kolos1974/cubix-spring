package hu.cubix.logistic.kolos.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.cubix.logistic.kolos.dto.MilestoneDto;
import hu.cubix.logistic.kolos.dto.SectionDto;
import hu.cubix.logistic.kolos.model.Milestone;
import hu.cubix.logistic.kolos.model.Section;

@Mapper(componentModel = "spring")
public interface SectionMapper {
	
	List<SectionDto> sectionsToDtos(List<Section> sections);

	
	// A példa kedvéért teszek bele mapping-et
	@Mapping(target = "sectionId", source = "sectionId")
	@Mapping(target = "orderNum", source = "orderNum")
	
	// A kereszthivatkozás miatt kell kiiktatni a section alatti ...-t
	// @OneToMany(mappedBy= "company") esetén!
	// @Mapping(target = "company.employees", ignore=true)
	SectionDto sectionToDto(Section section);

	@InheritInverseConfiguration
	Section dtoToSection(SectionDto sectionDto);

	List<Section> dtosToSections(List<SectionDto> sections);

}
