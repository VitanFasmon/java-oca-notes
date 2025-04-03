package book.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Chapter2 {
	public Chapter2() {
		System.out.println("_______________________________________");
		System.out.println("Chapter2");
		numericPromotion();
		unaryOpertors();
		logicalOperators(new textValue());
		javaStatements(7863);
	}

	void numericPromotion() {
		int x1 = 1;
		long y1 = 33;
		System.out.println("x1*y1= " + (x1 * y1));
		double x2 = 10.65;
		float y2 = 33.54F;
		System.out.println("x2+y2= " + (x2 + y2));

	}

	void unaryOpertors() {
		int x = 5;
		x = -x;
		System.out.println("x: " + x);
	}

	class textValue {
		boolean getValue() {
			return true;
		}
	}

	void logicalOperators(textValue x) {
		if (x != null && x.getValue()) {
			// COMPILES even if x is null.
		}
		if (x != null & x.getValue()) {
			// Throws exception if x is null
		}
	}

	void javaStatements(int number) {
		switch (number) {
		case 1:
			System.out.println("ONE");
			break;
		case 2:
			System.out.println("TWO");
			break;
		case 3:
			System.out.println("THREE");
			break;
		case 4:
			System.out.println("FOUR");
			break;
		case 5:
			System.out.println("FIVE");
			break;
		default:
			System.out.println("DEFAULT");
			break;
		}
		int x = 0;
		for (long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
			System.out.println("y: " + y);
		}
		List<String> testList = new ArrayList<String>(
				Arrays.asList(new String[] { "item 1", "item 2", "item 3", "item 4", "item 5" }));
		Iterator i = testList.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		for (String item : testList) {
			System.out.println(item);
		}
		int[][] twoDimentionalArray = { { 1, 2, 3 }, { 10, 20, 30 }, { 100, 200, 300 }, { 1000, 2000, 3000 } };
		OUTER_LOOP: for (int[] outerItem : twoDimentionalArray) {
			INNER_LOOP: for (int innerItem : outerItem) {
				if(innerItem==300) {
					break INNER_LOOP;
				}
				System.out.println(innerItem);
			}
		}
	}
}
