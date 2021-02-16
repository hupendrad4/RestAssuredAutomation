package com.RestAssured_AutomationFramework_utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static String empName() {

		String generateString = RandomStringUtils.randomAlphabetic(3);
		return ("User" + generateString);

	}

	public static String empSal() {

		String generateString = RandomStringUtils.randomNumeric(5);
		return generateString;

	}

	public static String empAge() {

		String generateString = RandomStringUtils.randomNumeric(5);
		return generateString;

	}

}
