package com.ust.adddaystodate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.adddaystodate.model.DateCalculatorModel;
import com.ust.adddaystodate.service.DateCalculatorService;

@Validated
@RestController
public class DateCalculatorController {

	@Autowired
	private DateCalculatorService dateCalculatorService;

	@PostMapping("/date")
	public String dateCalculator(@RequestBody @Valid DateCalculatorModel inputValues) {

		return dateCalculatorService.dateCalculator(inputValues);

	}

}
