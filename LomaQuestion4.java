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
public class LomaQuestion4 {

	@SuppressWarnings("unused")
	private static final String[] sampleInputs = {
			"Square",
			"Circle",
			"Triangle",
			"Rectangle",
	};

	private static final Map<String, String> shapeDefinitions = new HashMap<>();

	static {
		shapeDefinitions.put("Square",
				"The square is a highly symmetric object. There are four lines of reflectional symmetry and it has rotational symmetry of order 4 (through 90°, 180°, and 270°).");
		shapeDefinitions.put("Circle", "A circle is a simple shape in Euclidean geometry. It is the set of all points in a plane that are at a given distance from a given point, the centre.");
		shapeDefinitions.put("Triangle", "A triangle is a polygon with three edges and three vertices. It is one of the basic shapes in geometry.");
		shapeDefinitions.put("Rectangle", "In Euclidean plane geometry, a rectangle is a quadrilateral with four right angles. It can also be defined as an equiangular quadrilateral.");
		/* Add more shapes and definitions here */
	}

	public static String getShapeDefinition(String shape) {
		return shapeDefinitions.getOrDefault(shape, "Definition not available.");
	}

	private static String takeInput() {
		Scanner scanner = null;

		try {
			scanner = new Scanner(System.in);

			System.out.println("Input your shape:");
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
		String shape = takeInput();
		System.out.println(getShapeDefinition(shape));
	}
}
