package hu.cubix.logistic.kolos.model;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Milestone {

	@Id
	@GeneratedValue
	private long milestoneId;
	
	@ManyToOne
	private Address address;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
	private LocalDateTime plannedTime;

	public Milestone() {
	//	super();
	}

	public Milestone(Address address, LocalDateTime plannedTime) {
	//	super();
		this.address = address;
		this.plannedTime = plannedTime;
	}

	public long getMilestoneId() {
		return milestoneId;
	}

	public void setMilestoneId(long milestoneId) {
		this.milestoneId = milestoneId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalDateTime getPlannedTime() {
		return plannedTime;
	}

	public void setPlannedTime(LocalDateTime plannedTime) {
		this.plannedTime = plannedTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(milestoneId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Milestone other = (Milestone) obj;
		return milestoneId == other.milestoneId;
	}

	@Override
	public String toString() {
		return "Milestone [milestoneId=" + milestoneId + ", address=" + address + ", plannedTime=" + plannedTime + "]";
	}
	
		
	
	
}
