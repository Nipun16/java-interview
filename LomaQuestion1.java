/**
 * @author nipunaggarwal
 *
 */
package com.self.interview;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author nipunaggarwal
 *
 */
public class LomaQuestion1 {

	@SuppressWarnings("unused")
	private static final String[] sampleInputs = {
			"29-01-2024 10:10",
			"19-01-2023 09:10",
			"09-01-2024 20:10"
	};

	private static final Map<Integer, String> DAY_SUFFIXES = new HashMap<>();

	static {
		DAY_SUFFIXES.put(1, "First");
		DAY_SUFFIXES.put(2, "Second");
		DAY_SUFFIXES.put(3, "Third");
		DAY_SUFFIXES.put(21, "Twenty first");
		DAY_SUFFIXES.put(22, "Twenty second");
		DAY_SUFFIXES.put(23, "Twenty third");
		DAY_SUFFIXES.put(31, "Thirty first");
	}

	private static final String[] units = {
			"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
	};

	private static final String[] teens = {
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
	};

	private static final String[] tens = {
			"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
	};

	private static String questionString = "Enter the date and time (dd-MM-yyyy HH:mm):";
	private static String errorString = "Invalid date and time format. Please enter the date and time in the specified format.";

	public static String convert(final int n) {
		if (n < 0) {
			return "Minus " + convert(-n);
		}

		if (n < 10) {
			return units[n];
		}

		if (n < 20) {
			return teens[n - 10];
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		return convert(n / 1000) + " Thousand" + ((n % 1000 != 0) ? " " : "") + convert(n % 1000);
	}

	public static String convertDateTime(String input) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(input, formatter);

		int day = dateTime.getDayOfMonth();
		String daySuffix = DAY_SUFFIXES.getOrDefault(day, "th");
		String dayWord = daySuffix.equals("th") ? convert(day) + daySuffix : daySuffix;

		String monthWord = dateTime.getMonth().toString().toLowerCase();
		monthWord = monthWord.substring(0, 1).toUpperCase() + monthWord.substring(1);

		String yearWord = convert(dateTime.getYear());

		String hourWord = convert(dateTime.getHour());
		String minuteWord = convert(dateTime.getMinute());

		return String.format("%s of %s %s %s hours past %s minutes",
				dayWord, monthWord, yearWord, hourWord, minuteWord);
	}

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
		} finally {
			scanner.close();
		}

		return null;

	}

	public static void main(String[] args) {

		String output = convertDateTime(takeInput());
		System.out.println(output);

	}
}
