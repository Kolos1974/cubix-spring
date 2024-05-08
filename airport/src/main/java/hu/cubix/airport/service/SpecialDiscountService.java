package hu.cubix.airport.service;

import org.springframework.stereotype.Service;

//@Service
public class SpecialDiscountService implements DiscountService {

	@Override
	public int getDiscountPercent(int totalPrice) {
		return totalPrice > 1000 ? 15 : 10;
	}

}
