/**
 * @author nipunaggarwal
 *
 */
package com.self.interview;

import java.util.Scanner;

/**
 * @author nipunaggarwal
 *
 */
public class LomaQuestion5 {

	@SuppressWarnings("unused")
	private static final String[] sampleInputs = {
			"Recent years have brought about an influx of new electric motorcycles geared towards fun and enjoyment, particularly off-road. From weird and interesting bikes that blur the lines between e-bike and motorcycle to full on electric motocross, it’s obvious that the future is bright when it comes to electric off-roader.",
			"Recent years have brought about an influx of new electric motorcycles geared towards fun and enjoyment, particularly off-road. From weird and interesting bikes that blur the lines between e-bike and motorcycle to full on electric motocross",
			"Recent years have brought about an influx of new electric motorcycles geared towards fun and enjoyment, particularly off-road. ",
	};

	private static int countWords(String text) {
		String[] words = text.split("\\s+");
		return words.length;
	}

	private static int countVowels(String text) {
		int count = 0;
		for (char ch : text.toLowerCase().toCharArray()) {
			if ("aeiou".indexOf(ch) != -1) {
				count++;
			}
		}
		return count;
	}

	private static int countSentences(String text) {
		String[] sentences = text.split("[.!?]");
		return sentences.length;
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

		String inputText = takeInput();

		int wordCount = countWords(inputText);
		int vowelCount = countVowels(inputText);
		int sentenceCount = countSentences(inputText);

		System.out.println("Words: " + wordCount + ", Vowels: " + vowelCount + ", Sentences: " + sentenceCount);
	}
}
