package hu.cubix.logistic.kolos.dto;

import java.time.LocalDateTime;

import hu.cubix.logistic.kolos.model.Address;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class MilestoneDto {
	
	
	private long milestoneId;
	
	@NotNull
	private Address address;
	// @Past
	private LocalDateTime plannedTime;
	
	
	public MilestoneDto() {
	//	super();
	}


	public MilestoneDto(@NotNull Address address, LocalDateTime plannedTime) {
		super();
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
	public String toString() {
		return "MilestoneDto [milestoneId=" + milestoneId + ", address=" + address + ", plannedTime=" + plannedTime
				+ "]";
	}


	

}
