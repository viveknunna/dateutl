package com.ust.adddaystodate.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ust.adddaystodate.model.DateCalculatorModel;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DateCalculatorControllerTest {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	public void DateCalculatorTest() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<DateCalculatorModel> request = new HttpEntity<>(new DateCalculatorModel("23/10/2017", 2), headers);

		ResponseEntity<String> response = restTemplate.postForEntity("/date", request, String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
	}

	@Test
	public void DayNotFoundCalculatorTest() {

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<DateCalculatorModel> request = new HttpEntity<>(new DateCalculatorModel("366/10/2017", 2), headers);

		ResponseEntity<String> response = restTemplate.postForEntity("/date", request, String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

	}

	@Test
	public void MonthNotFoundCalculatorTest() {

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<DateCalculatorModel> request = new HttpEntity<>(new DateCalculatorModel("3/133/2017", 2), headers);

		ResponseEntity<String> response = restTemplate.postForEntity("/date", request, String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

	}

	@Test
	public void GetDateCalculatorTest() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<DateCalculatorModel> request = new HttpEntity<>(new DateCalculatorModel("20/10/2017", 2), headers);

		ResponseEntity<String> response = restTemplate.postForEntity("/date", request, String.class);
		assertThat(response.getBody()).isEqualTo("22/10/2017");
	}
}
