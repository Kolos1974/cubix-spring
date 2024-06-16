package hu.cubix.airport.service;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
//import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {
	
	@InjectMocks
	PriceService priceService;
	
	@Mock
	DiscountService discountService;
	
	
	@Test
	void testGetFinalPrice() {
		// ARRANGE
		priceService = new PriceService(p -> 5);

		// ACT
		int result = priceService.getFinalPrice(100);
		
		// ASSERT
		// assertEquals(95, result);
		assertThat(result).isEqualTo(95);
		
		// ANNIHILATE: empty this case
	}
	
	@Test
	void testGetFinalPrise2() throws Exception {
		//Mockito.when(discountService.getDiscountPercent(100)).thenReturn(5);
		Mockito.when(discountService.getDiscountPercent(Mockito.anyInt())).thenReturn(5);
	
		int result = priceService.getFinalPrice(100);
		
		// assertEquals(95, result);
		assertThat(result).isEqualTo(95);
		
		Mockito.verify(discountService).getDiscountPercent(100);
		verify(discountService).getDiscountPercent(100);
		
	}
	

}
