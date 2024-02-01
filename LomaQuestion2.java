/**
 * @author nipunaggarwal
 *
 */
package com.self.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author nipunaggarwal
 *
 */
public class LomaQuestion2 {

	@SuppressWarnings("unused")
	private static final String[] sampleInputs = {
			"15th of March two thousand twenty three five hours past twenty minutes",
			"5th of September two thousand twenty six fifteen hours past forty-five minutes",
			"12th of November two thousand twenty two eight hours past five minutes",
			"3rd of June two thousand twenty five twelve hours past thirty minutes",
			"20th of December two thousand twenty seven twenty-two hours past fifteen minutes"
	};

	private static final Map<String, Integer> MONTHS = new HashMap<>();
	private static final Map<String, Integer> NUMBERS = new HashMap<>();

	static {
		/* Initialize month mappings */
		MONTHS.put("January", 1);
		MONTHS.put("February", 2);
		MONTHS.put("March", 3);
		MONTHS.put("April", 4);
		MONTHS.put("May", 5);
		MONTHS.put("June", 6);
		MONTHS.put("July", 7);
		MONTHS.put("August", 8);
		MONTHS.put("September", 9);
		MONTHS.put("October", 10);
		MONTHS.put("November", 11);
		MONTHS.put("December", 12);

		/* Initialize number mappings */
		NUMBERS.put("one", 1);
		NUMBERS.put("two", 2);
		NUMBERS.put("three", 3);
		NUMBERS.put("four", 4);
		NUMBERS.put("five", 5);
		NUMBERS.put("six", 6);
		NUMBERS.put("seven", 7);
		NUMBERS.put("eight", 8);
		NUMBERS.put("nine", 9);
		NUMBERS.put("ten", 10);
		NUMBERS.put("eleven", 11);
		NUMBERS.put("twelve", 12);

		/* Populate values for thirteen to twenty */
		NUMBERS.put("thirteen", 13);
		NUMBERS.put("fourteen", 14);
		NUMBERS.put("fifteen", 15);
		NUMBERS.put("sixteen", 16);
		NUMBERS.put("seventeen", 17);
		NUMBERS.put("eighteen", 18);
		NUMBERS.put("nineteen", 19);

		/* Populate values for twenty-one to twenty-nine */
		NUMBERS.put("twenty", 20);
		NUMBERS.put("twenty-one", 21);
		NUMBERS.put("twenty-two", 22);
		NUMBERS.put("twenty-three", 23);
		NUMBERS.put("twenty-four", 24);
		NUMBERS.put("twenty-five", 25);
		NUMBERS.put("twenty-six", 26);
		NUMBERS.put("twenty-seven", 27);
		NUMBERS.put("twenty-eight", 28);
		NUMBERS.put("twenty-nine", 29);

		/* Populate values for thirty, forty, fifty */
		NUMBERS.put("thirty", 30);
		NUMBERS.put("thirty-one", 31);
		NUMBERS.put("thirty-two", 32);
		NUMBERS.put("thirty-three", 33);
		NUMBERS.put("thirty-four", 34);
		NUMBERS.put("thirty-five", 35);
		NUMBERS.put("thirty-six", 36);
		NUMBERS.put("thirty-seven", 37);
		NUMBERS.put("thirty-eight", 38);
		NUMBERS.put("thirty-nine", 39);
		NUMBERS.put("forty", 40);
		NUMBERS.put("forty-one", 41);
		NUMBERS.put("forty-two", 42);
		NUMBERS.put("forty-three", 43);
		NUMBERS.put("forty-four", 44);
		NUMBERS.put("forty-five", 45);
		NUMBERS.put("forty-six", 46);
		NUMBERS.put("forty-seven", 47);
		NUMBERS.put("forty-eight", 48);
		NUMBERS.put("forty-nine", 49);
		NUMBERS.put("fifty", 50);
		NUMBERS.put("fifty-one", 51);
		NUMBERS.put("fifty-two", 52);
		NUMBERS.put("fifty-three", 53);
		NUMBERS.put("fifty-four", 54);
		NUMBERS.put("fifty-five", 55);
		NUMBERS.put("fifty-six", 56);
		NUMBERS.put("fifty-seven", 57);
		NUMBERS.put("fifty-eight", 58);
		NUMBERS.put("fifty-nine", 59);
		NUMBERS.put("sixty", 60);
	}

	private static int convertYear(String[] yearParts) {

		if (yearParts.length != 4) {
			throw new IllegalArgumentException("Invalid yearParts array");
		}

		int year = NUMBERS.getOrDefault(yearParts[0], 0) * 1000;

		int yearPartsTwo = NUMBERS.getOrDefault(yearParts[2], 0);
		if (isDoubleDigit(yearPartsTwo)) {
			year += yearPartsTwo * 1;
		} else {
			year += yearPartsTwo * 10;
		}

		year += NUMBERS.getOrDefault(yearParts[3], 0);

		return year;
	}

	private static boolean isDoubleDigit(int number) {
		if (number >= 10) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	private static int convertHour(String hourWord) {
		return NUMBERS.getOrDefault(hourWord.toLowerCase(), 0);
	}

	private static int convertMinute(String minuteWord) {
		return NUMBERS.getOrDefault(minuteWord.toLowerCase(), 0);
	}

	public static String convertVerboseDateToStandard(String verboseDate) {
		String[] words = verboseDate.split(" ");

		/* Extract day, month, year, hour, and minute */
		int day = Integer.parseInt(words[0].substring(0, words[0].length() - 2));
		int month = MONTHS.get(words[2]);
		int year = convertYear(new String[] { words[3], words[4], words[5], words[6] });
		int hour = convertHour(words[7]);
		int minute = convertMinute(words[10]);

		return String.format("%02d-%02d-%d %02d:%02d", day, month, year, hour, minute);
	}

	private static String takeInput() {
		Scanner scanner = null;

		try {
			scanner = new Scanner(System.in);

			System.out.println("Input your text:");
			String inputText = scanner.nextLine();

			return inputText;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return null;
	}

	public static void main(String[] args) {
		String input = takeInput();
		String output = convertVerboseDateToStandard(input);
		System.out.println(output);
	}
}
