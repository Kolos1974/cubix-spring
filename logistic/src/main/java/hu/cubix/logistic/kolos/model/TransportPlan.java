package hu.cubix.logistic.kolos.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TransportPlan {
	
	@Id
    @GeneratedValue
	private long transportPlanId;
	private double expectedIn;
	
    @OneToMany
    private List<Section> sections;

	public TransportPlan() {
	//	super();
	}

	public TransportPlan(double expectedIn) {
	//	super();
		this.expectedIn = expectedIn;
	}
	
	
	public long getTransportPlanId() {
		return transportPlanId;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(transportPlanId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransportPlan other = (TransportPlan) obj;
		return transportPlanId == other.transportPlanId;
	}

	@Override
	public String toString() {
		return "TransportPlan [transportPlanId=" + transportPlanId + ", expectedIn=" + expectedIn + ", sections="
				+ sections + "]";
	}
    

}
