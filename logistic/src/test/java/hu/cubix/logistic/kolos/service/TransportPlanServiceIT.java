package hu.cubix.logistic.kolos.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import hu.cubix.logistic.kolos.model.TransportPlan;
import hu.cubix.logistic.kolos.repository.TransportPlanRepository;

@SpringBootTest
@AutoConfigureTestDatabase
public class TransportPlanServiceIT {

	@Autowired
	TransportPlanService transportPlanService;
	
	@Autowired
	TransportPlanRepository transportPlanRepository;
	
	
	@BeforeEach
	public void init() {
		transportPlanRepository.deleteAllInBatch();
		
	}
	
	
	@Test
	void testCreateTransportPlan() throws Exception {
		/// ARRANGE
		double expectedValue = 150;
		TransportPlan newTransportPlan = new TransportPlan(expectedValue); 
		
		// ACT
		long newTransportPlanId = createTransportPlan(expectedValue);
		
		// ASSERT
		TransportPlan savedTransportPlan = transportPlanRepository.findById(newTransportPlanId).get();
		assertThat(savedTransportPlan.getExpectedIn()).isEqualTo(expectedValue);
		assertThat(savedTransportPlan.getExpectedIn()).isEqualTo(newTransportPlan.getExpectedIn());
	}
	
	private long createTransportPlan(double expectedIn) {
		return transportPlanRepository.save(new TransportPlan(expectedIn)).getTransportPlanId();
	}
	
	
}
