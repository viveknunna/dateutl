package com.ust.adddaystodate.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class DateCalculatorModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "date value should not be null")
	@NotEmpty(message = "date value should not be empty")
	private String date;

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
