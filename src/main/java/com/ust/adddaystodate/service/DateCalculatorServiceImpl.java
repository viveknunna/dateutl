package com.ust.adddaystodate.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ust.adddaystodate.model.DateCalculatorModel;
import com.ust.adddaystodate.model.DateUtilityModel;

@Service
public class DateCalculatorServiceImpl implements DateCalculatorService {

	private static final Map<Integer, Integer> daysInMonth;

	static {
		daysInMonth = new HashMap<Integer, Integer>();
		daysInMonth.put(1, 31);
		daysInMonth.put(2, 28);
		daysInMonth.put(3, 31);
		daysInMonth.put(4, 30);
		daysInMonth.put(5, 31);
		daysInMonth.put(6, 30);
		daysInMonth.put(7, 31);
		daysInMonth.put(8, 31);
		daysInMonth.put(9, 30);
		daysInMonth.put(10, 31);
		daysInMonth.put(11, 30);
		daysInMonth.put(12, 31);
	}

	@Override
	public String dateCalculator(DateCalculatorModel inputValues) {

		String[] sArray = inputValues.getDate().split("/");
		int day = Integer.valueOf(sArray[0]);
		int month = Integer.valueOf(sArray[1]);
		int year = Integer.valueOf(sArray[2]);
		int incrementdays = inputValues.getDays();
		if (day != 0 && day <= 31) {
			if (month > 0 && month <= 12) {
				if(month==2 && day>29) {
					throw new DayorMonthNotFoundException(
							"the feb month days should be in 1 to 29. please correct the month and try again");
				}
				DateUtilityModel dateUtilityModel = addOrSubDays(day + incrementdays, month, year);
				return dateUtilityModel.getDay() + "/" + dateUtilityModel.getMonth() + "/" + dateUtilityModel.getYear();
			}
			else {
				throw new DayorMonthNotFoundException(
						"Month Range Excced. Please Correct It and Try Again");
			}
		} else {
			throw new DayorMonthNotFoundException("Date Range Excced.. Please Correct It and Try Again");
		}

	}

	private DateUtilityModel addOrSubDays(int days, int month, int year) {
		if (days > 0 && days <= getNoOfDaysInMonth(month, year)) {
			return new DateUtilityModel(days, month, year);
		} else if (days <= 0) {
			month = month - 1;
			if (month == 0) {
				month = 12;
				year = year - 1;
			}
			days = getNoOfDaysInMonth(month, year) + days;
		} else {
			month = month + 1;
			if (month > 12) {
				month = 1;
				year = year + 1;
			}
			days = days - getNoOfDaysInMonth(month, year);
		}
		return addOrSubDays(days, month, year);
	}

	private int getNoOfDaysInMonth(int month, int year) {
		if (month == 2 && checkIsLeepYear(year)) {
			return daysInMonth.get(month) + 1;
		}
		return daysInMonth.get(month);
	}

	private boolean checkIsLeepYear(int year) {
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			return true;
		}
		return false;
	}

}
