package hu.cubix.logistic.kolos.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Section {

	
	@Id
    @GeneratedValue
	private long sectionId;	
	
	@ManyToOne
	private TransportPlan transportPlan;
	
	private int orderNum;
	
	@ManyToOne
	private Milestone startMileStone;
	@ManyToOne
	private Milestone endMilestone;
	
	
	public Section() {
	//	super();
	}

	
	

	public Section(TransportPlan transportPlan, int orderNum, Milestone startMileStone, Milestone endMilestone) {
		// super();
		this.transportPlan = transportPlan;
		this.orderNum = orderNum;
		this.startMileStone = startMileStone;
		this.endMilestone = endMilestone;
	}


	/*
	public Section(int orderNum, Milestone startMileStone, Milestone endMilestone) {
		super();
		this.orderNum = orderNum;
		this.startMileStone = startMileStone;
		this.endMilestone = endMilestone;
	}
	*/
	

	public long getSectionId() {
		return sectionId;
	}


	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}


	public TransportPlan getTransportPlan() {
		return transportPlan;
	}


	public void setTransportPlan(TransportPlan transportPlan) {
		this.transportPlan = transportPlan;
	}


	public int getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}


	public Milestone getStartMileStone() {
		return startMileStone;
	}


	public void setStartMileStone(Milestone startMileStone) {
		this.startMileStone = startMileStone;
	}


	public Milestone getEndMilestone() {
		return endMilestone;
	}


	public void setEndMilestone(Milestone endMilestone) {
		this.endMilestone = endMilestone;
	}


	@Override
	public int hashCode() {
		return Objects.hash(sectionId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		return sectionId == other.sectionId;
	}


	@Override
	public String toString() {
		return "Section [sectionId=" + sectionId + ", transportPlan=" + transportPlan + ", orderNum=" + orderNum
				+ ", startMileStone=" + startMileStone + ", endMilestone=" + endMilestone + "]";
	}
	
}
