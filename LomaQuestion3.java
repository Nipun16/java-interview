/**
 * @author nipunaggarwal
 *
 */
package com.self.interview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

/**
 * @author nipunaggarwal
 *
 */
public class LomaQuestion3 {
	
	@SuppressWarnings("unused")
	private static final String[] sampleInputs = {
			"29-01-2024, 31-01-2024",
			"19-01-2024, 23-01-2024",
			"02-01-2024, 09-01-2024",
	};


	private static String questionString = "Enter date input (dd-MM-yyyy):";
	private static String errorString = "Invalid date format. Please enter the date in the specified format.";

	private static final String IST_TIMEZONE = "Asia/Kolkata";
	private static final String DATE_FORMAT = "dd-MM-yyyy";

	public static long daysBetween(Date one, Date two) {
		return Math.abs(daysBetweenWithSign(one, two));
	}

	public static long daysBetween(LocalDate one, LocalDate two) {
		return Math.abs(daysBetweenWithSign(one, two));
	}

	public static LocalDate convertToLocalDate(Date date) {
		return convertToLocalDate(date, IST_TIMEZONE);
	}

	public static LocalDate convertToLocalDate(Date date, String timeZone) {
		if (date == null) {
			return null;
		}

		if (date instanceof java.sql.Date) {
			return ((java.sql.Date) date).toLocalDate();
		}

		ZoneId zoneId = ZoneId.of(timeZone);
		Instant instant = date.toInstant();
		return instant.atZone(zoneId).toLocalDate();
	}

	public static long daysBetweenWithSign(Date one, Date two) {
		LocalDate start = convertToLocalDate(one);
		LocalDate end = convertToLocalDate(two);

		return daysBetweenWithSign(start, end);
	}

	public static long daysBetweenWithSign(LocalDate one, LocalDate two) {
		return ChronoUnit.DAYS.between(one, two);
	}

	public static Date customDateParser(String dateInput, String dateFormat) {
		if (dateInput != null) {
			SimpleDateFormat formatterOutput = new SimpleDateFormat(dateFormat);
			try {
				return formatterOutput.parse(dateInput);
			} catch (ParseException e) {
				System.out.println("Parsing error: " + e.getMessage());
			}
		}

		return null;
	}

	@SuppressWarnings("resource")
	private static String takeInput() {
		Scanner scanner = null;

		try {
			scanner = new Scanner(System.in);

			System.out.println(questionString);
			String input = scanner.nextLine();

			return input;

		} catch (Exception e) {
			System.out.print(errorString);
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		Date date1 = customDateParser(takeInput(), DATE_FORMAT);
		Date date2 = customDateParser(takeInput(), DATE_FORMAT);

		System.out.println(daysBetweenWithSign(date1, date2) + " days");
	}

}
