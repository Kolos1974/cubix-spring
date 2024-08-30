package hu.cubix.logistic.kolos.dto;

import hu.cubix.logistic.kolos.model.Milestone;
import hu.cubix.logistic.kolos.model.TransportPlan;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class SectionDto {

	
	private long sectionId;	
	
	@NotNull
	private TransportPlan transportPlan;
	
	@Positive
	private int orderNum;
	
	@NotNull
	private Milestone startMileStone;
	@NotNull
	private Milestone endMilestone;
	
	
	public SectionDto() {
		super();
	}

	public SectionDto(@NotNull TransportPlan transportPlan, @Positive int orderNum, @NotNull Milestone startMileStone,
			@NotNull Milestone endMilestone) {
		super();
		this.transportPlan = transportPlan;
		this.orderNum = orderNum;
		this.startMileStone = startMileStone;
		this.endMilestone = endMilestone;
	}

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
	public String toString() {
		return "SectionDto [sectionId=" + sectionId + ", transportPlan=" + transportPlan + ", orderNum=" + orderNum
				+ ", startMileStone=" + startMileStone + ", endMilestone=" + endMilestone + "]";
	}
	
	
}
