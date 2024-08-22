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
import hu.cubix.logistic.kolos.dto.TransportPlanDto;
import hu.cubix.logistic.kolos.dto.AddressDto;
import hu.cubix.logistic.kolos.mapper.AddressMapper;
import hu.cubix.logistic.kolos.model.Address;
import hu.cubix.logistic.kolos.model.TransportPlan;
import hu.cubix.logistic.kolos.service.AddressService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

	
	@Autowired
	AddressService addressService;
	
	@Autowired
	AddressMapper addressMapper;

	
	
	@PostMapping
	public ResponseEntity<Long> addAddress(@RequestBody @Valid AddressDto addressDto)
	{
		
		Address address = addressMapper.dtoToAddress(addressDto);

		if(address == null || address.getAddressId() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		
		Address newAddress = addressService.create(address);
		
		// Teszt
		System.out.println("New address Id:"+ newAddress.getAddressId());
		
		return ResponseEntity.ok(newAddress.getAddressId());
	}
	
	
	@GetMapping
	public List<AddressDto> findAll(){
		List<Address> addresses = null;
		addresses = addressService.findAll();
		return addressMapper.addressToDtos(addresses);
	}
	
}
