package hu.cubix.logistic.kolos.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.cubix.logistic.kolos.dto.TransportPlanDto;
import hu.cubix.logistic.kolos.model.TransportPlan;

@Mapper(componentModel = "spring")
public interface TransportPlanMapper {
	

	// A példa kedvéért teszek bele mapping-et
	@Mapping(target = "transportPlanId", source = "transportPlanId")
	@Mapping(target = "expectedIn", source = "expectedIn")
	public TransportPlanDto transportPlanToDto(TransportPlan transportPlan);

	@InheritInverseConfiguration
	public TransportPlan dtoToTransportPlan(TransportPlanDto transportPlanDto);

}
