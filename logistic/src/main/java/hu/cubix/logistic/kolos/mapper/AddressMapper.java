package hu.cubix.logistic.kolos.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import hu.cubix.logistic.kolos.dto.AddressDto;
import hu.cubix.logistic.kolos.model.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

	
	public AddressDto addressToDto(Address address);

	@InheritInverseConfiguration
	public Address dtoToAddress(AddressDto addressDto);

	
	List<AddressDto> addressToDtos(List<Address> addresss);	
	
	
	List<Address> dtosToAddress(List<AddressDto> address);
}
