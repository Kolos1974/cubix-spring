package hu.cubix.logistic.kolos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.cubix.logistic.kolos.model.Address;


public interface AddressRepository extends JpaRepository<Address ,Long> {

}
