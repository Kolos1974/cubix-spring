package hu.cubix.logistic.kolos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.logistic.kolos.model.Address;
import hu.cubix.logistic.kolos.repository.AddressRepository;
import jakarta.transaction.Transactional;

@Service
public class AddressService {

	
	@Autowired
	AddressRepository addressRepository;
	
	@Transactional
	public Address create(Address address)
	{
		return save(address);
	}

	@Transactional
	public Address save(Address address) {

		return addressRepository.save(address);
	}

	
	public List<Address> findAll() {
		return addressRepository.findAll();
	}
	
	
}
