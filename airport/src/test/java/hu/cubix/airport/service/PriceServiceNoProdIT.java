package hu.cubix.airport.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class PriceServiceNoProdIT {

	
	
	@Autowired
	PriceService priceService;
	
	
	@Test
	void testGetFinalPrice() throws Exception {
		int result = priceService.getFinalPrice(100);
		
		// assertEquals(90, result);
		assertThat(result).isEqualTo(90);
		
	}
	
	
}





