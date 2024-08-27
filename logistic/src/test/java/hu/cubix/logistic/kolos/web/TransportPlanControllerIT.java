package hu.cubix.logistic.kolos.web;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

import hu.cubix.logistic.kolos.dto.TransportPlanDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class TransportPlanControllerIT {

	private static final String BASE_URI = "/api/transportPlans";
	
	@Autowired
	WebTestClient webTestClient;
	
	@Test
	void testThatNewValidTransportPlanCanBeSaved() throws Exception {
		List<TransportPlanDto> transportPlansBefore = getAllTransportPlans();

		TransportPlanDto newTransportPlan = new TransportPlanDto(15555, null);
				
		saveTransportPlan(newTransportPlan).expectStatus().isOk();

		List<TransportPlanDto> transportPlansAfter = getAllTransportPlans();

		assertThat(transportPlansAfter.size()).isEqualTo(transportPlansBefore.size() + 1);
		
		/*
		assertThat(transportPlansAfter.get(transportPlansAfter.size() - 1)).usingRecursiveComparison().ignoringFields("transportPlanId")
				.isEqualTo(newTransportPlan);
		*/
	}

	private List<TransportPlanDto> getAllTransportPlans() {
		List<TransportPlanDto> responseList = webTestClient
				.get()
				.uri(BASE_URI)
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(TransportPlanDto.class)
				.returnResult()
				.getResponseBody();
		
		Collections.sort(responseList, Comparator.comparing(TransportPlanDto::getTransportPlanId));
		
		return responseList;
	}
	
	private ResponseSpec saveTransportPlan(TransportPlanDto newTransportPlan) {
		return webTestClient
				.post()
				.uri(BASE_URI)
				.bodyValue(newTransportPlan)
				.exchange();
	}
	
}
