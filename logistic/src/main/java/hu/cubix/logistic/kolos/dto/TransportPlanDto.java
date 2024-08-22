package hu.cubix.logistic.kolos.dto;

import java.util.List;

import hu.cubix.logistic.kolos.model.Section;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class TransportPlanDto {

	private long transportPlanId;
	@PositiveOrZero
	private double expectedIn;
	
	private List<Section> sections;

	public TransportPlanDto() {
		//super();
	}

	public TransportPlanDto(@PositiveOrZero double expectedIn, List<Section> sections) {
		// super();
		this.expectedIn = expectedIn;
		this.sections = sections;
	}

	public TransportPlanDto(@PositiveOrZero double expectedIn) {
		// super();
		this.expectedIn = expectedIn;
	}

	// A mappelés miatt szükség van az Id getter/setter-re!! 
	// Az integrációs teszt miatt is szükséges !!
	public long getTransportPlanId() {
		return transportPlanId;
	}
	
	// Erre szükség van?
	public void setTransportPlanId(long transportPlanId) {
		this.transportPlanId = transportPlanId;
	}
	

	public double getExpectedIn() {
		return expectedIn;
	}

	public void setExpectedIn(double expectedIn) {
		this.expectedIn = expectedIn;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	
	
	
}
