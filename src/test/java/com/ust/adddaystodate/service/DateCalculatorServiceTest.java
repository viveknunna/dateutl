package com.ust.adddaystodate.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ust.adddaystodate.model.DateCalculatorModel;

@RunWith(MockitoJUnitRunner.class)
public class DateCalculatorServiceTest {

	@MockBean
	private DateCalculatorService serviceImpl = new DateCalculatorServiceImpl();

	@Test
	public void DateCalculatorTest() {

		String date = serviceImpl.dateCalculator(new DateCalculatorModel("26/10/2020", 3));
		assertThat(date).isEqualTo("29/10/2020");
	}

	
}
