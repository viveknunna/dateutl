package com.ust.adddaystodate.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ust.adddaystodate.model.DateCalculatorModel;

@SpringBootTest
public class DateCalculatorServiceTest {

	@InjectMocks
	private DateCalculatorServiceImpl dateCalcService;

	@SuppressWarnings("deprecation")
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void dateCalculatorTest() {

		String date = dateCalcService.dateCalculator(new DateCalculatorModel("26/10/2020", 3));
		assertThat(date).isEqualTo("29/10/2020");

	}

	@Test
	public void testNegativeDays() {

		Throwable exception = assertThrows(DayorMonthNotFoundException.class,
				() -> dateCalcService.dateCalculator(new DateCalculatorModel("26/10/2020", -3)));
		assertEquals("days should not be negative", exception.getMessage());

	}
	@Test
	public void testInValidYear() {

		Throwable exception = assertThrows(DayorMonthNotFoundException.class,
				() -> dateCalcService.dateCalculator(new DateCalculatorModel("26/10/100", 3)));
		assertEquals("year value is invalid in the date", exception.getMessage());

	}
	
	@Test
	public void testInValidMonth() {

		Throwable exception = assertThrows(DayorMonthNotFoundException.class,
				() -> dateCalcService.dateCalculator(new DateCalculatorModel("26/66/1992", 3)));
		assertEquals("Month Range Exceed or Negative", exception.getMessage());

	}
	
	@Test
	public void testInValidDay() {

		Throwable exception = assertThrows(DayorMonthNotFoundException.class,
				() -> dateCalcService.dateCalculator(new DateCalculatorModel("40/12/1992", 3)));
		assertEquals("Day Range Exceed or Negative", exception.getMessage());

	}
	@Test
	public void testFebMonth() {

		Throwable exception = assertThrows(DayorMonthNotFoundException.class,
				() -> dateCalcService.dateCalculator(new DateCalculatorModel("30/2/1992", 3)));
		assertEquals("the feb month days should be in 1 to 29", exception.getMessage());

	}

}
