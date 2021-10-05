package com.ust.adddaystodate.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "date calculator")
public class DateCalculatorModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Input Date", 
            example = "11/10/2013", required = true, position = 0)
	@NotNull(message = "date value should not be null")
	@NotEmpty(message = "date value should not be empty")
	private String date;
	
	@ApiModelProperty(notes = "Input Days", 
            example = "2", required = true, position = 1)
	@NotNull(message = "days value should not be null")
	private Integer days;

	public DateCalculatorModel(
			@NotNull(message = "date value should not be null") @NotEmpty(message = "date value should not be empty") String date,
			@NotNull(message = "days value should not be null") Integer days) {
		super();
		this.date = date;
		this.days = days;
	}

	public DateCalculatorModel() {

	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "DateCalculatorModel [date=" + date + ", days=" + days + "]";
	}

}
