package hu.cubix.logistic.kolos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Section {

	
	@Id
    @GeneratedValue
	private long sectionId;	
}
