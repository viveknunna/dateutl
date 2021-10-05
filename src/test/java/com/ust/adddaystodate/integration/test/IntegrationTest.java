package com.ust.adddaystodate.integration.test;

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
public class IntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void dateCalIntegrationTest() throws Exception {
		DateCalculatorModel dateCalculatorModel = new DateCalculatorModel("10/10/2017", 2);
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<DateCalculatorModel> request = new HttpEntity<>(dateCalculatorModel, headers);

		ResponseEntity<String> response = restTemplate.postForEntity("/date", request, String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo("12/10/2017");
	}

}
