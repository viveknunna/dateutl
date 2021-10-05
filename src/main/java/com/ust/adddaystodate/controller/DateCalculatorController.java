package com.ust.adddaystodate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.adddaystodate.model.DateCalculatorModel;
import com.ust.adddaystodate.service.DateCalculatorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="Date Utility Rest API", value="DateCalculatorController")
@Validated
@RestController
public class DateCalculatorController {

	@Autowired
	private DateCalculatorService dateCalculatorService;
	
	@ApiOperation(value ="Calculate Date")
	@PostMapping("/date")
	public String dateCalculator(@ApiParam("Date info with number of input days")@RequestBody @Valid DateCalculatorModel inputValues) {

		return dateCalculatorService.dateCalculator(inputValues);

	}

}
