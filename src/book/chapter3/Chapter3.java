package book.chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

public class Chapter3 {
	public Chapter3() {
		System.out.println("_______________________________________");
		System.out.println("Chapter3");
		stringManpulation();
		usingStringBulder();
		understandingEquality();
		arrays();
		understandingArrayList();
		wrapperClasses();
		datesAndTimes();
	}

	void stringManpulation() {
		String one = new String("STRING ONE");
		System.out.println(one);
		StringBuilder strBuilderOne = new StringBuilder("String builder 1");
		System.out.println(strBuilderOne.capacity());
		System.out.println(strBuilderOne.length());
		System.out.println(strBuilderOne.charAt(0));
		System.out.println(strBuilderOne.substring(8, 14));
		System.out.println(strBuilderOne.substring(8, 8));
		strBuilderOne.append(77);
		System.out.println(strBuilderOne);
		String s1 = "string";
		String s2 = new String("string");
		String s3 = "string";
		System.out.println("s1==s3");
		System.out.println(s1 == s3);
		System.out.println("s1==s2");
		System.out.println(s1 == s2);
		System.out.println(s1.length());
		System.out.println(s1.charAt(4));
		System.out.println(s1.indexOf('t', 1));
		System.out.println(s1.indexOf("in", 0));
		System.out.println(s1.substring(1, 6));
		System.out.println(s1.substring(s1.indexOf('r')));
		System.out.println(s1.toUpperCase());
		System.out.println(s1.toLowerCase());
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));
		System.out.println(s1.startsWith("s"));
		System.out.println(s1.endsWith("g"));
		System.out.println(s1.contains("tr"));
		System.out.println(s1.replace('s', 'S'));
		System.out.println(s1.trim());

	}

	void usingStringBulder() {
		StringBuilder sb1 = new StringBuilder();
		for (char ch = 'a'; ch <= 'z'; ch++) {
			sb1.append(ch);
		}
		System.out.println(sb1);
		StringBuilder sb2 = new StringBuilder("start");
		sb2.append(" middle ");
		StringBuilder sb3 = sb2.append("end");
		sb3.append(" sb3_append");
		sb2.append(" (sb3 and sb2 point to the same object.)");
		System.out.println("sb2: " + sb2);
		System.out.println("sb3: " + sb3);
		System.out.println("sb3.length(): " + sb3.length());
		System.out.println("sb3.capacity: " + sb3.capacity());
	}

	class Tiger {
		String name;
	}

	void understandingEquality() {
		StringBuilder sbOne = new StringBuilder();
		StringBuilder sbTwo = new StringBuilder();
		StringBuilder sbThree = sbTwo.append("append something");
		System.out.print("sbOne == sbTwo ");
		System.out.println(sbOne == sbTwo);
		System.out.print("sbTwo == sbThree ");
		System.out.println(sbTwo == sbThree);
		String s1 = "hello world";
		String s2 = "hello world";
		String s3 = new String("hello world");
		String s4 = "hello world".trim();
		System.out.print("s1 == s2 ");
		System.out.println(s1 == s2);
		System.out.print("s1 == s3 ");
		System.out.println(s1 == s3);
		System.out.print("s1 == s4 ");
		System.out.println(s1 == s4);

		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		Tiger t3 = t1;

		System.out.println(t1 == t1);
		System.out.println(t1 == t2);
		System.out.println(t1 == t3);
		System.out.println(t1.equals(t2));
	}

	void arrays() {
		int[] intArray = new int[3]; // sets all values in the array to default values of the data type (in this case
										// int = 0)
		System.out.println("intArray[1] " + intArray[1]);
		int[] intArray2 = new int[] { 1, 2, 3, 4, 5 };
		int[] intArray3 = { 1, 2, 3, 4, 5 }; // anonymous array
		int[] array1; // ok
		int[] array2; // ok
		int array3[]; // ok
		int array4[]; // ok

		int[] array5, array6;
		int array7[], intValue;
		System.out.println(intArray3);
		System.out.println(java.util.Arrays.toString(intArray3));
		int[] unsortedNumbers = { 345, 456, 12, 786, 2, 45, 123, 476 };
		System.out.println(java.util.Arrays.toString(unsortedNumbers));
		java.util.Arrays.sort(unsortedNumbers);
		System.out.println(java.util.Arrays.toString(unsortedNumbers));
		String[] unsortedStrings = { "asd", "2", "5", "9", "10", "", "376a", "578", "3aasd", "žasdč" };
		System.out.println(java.util.Arrays.toString(unsortedStrings));
		java.util.Arrays.sort(unsortedStrings);
		System.out.println(java.util.Arrays.toString(unsortedStrings));
		System.out.println(java.util.Arrays.binarySearch(unsortedNumbers, 12));
		System.out.println(java.util.Arrays.binarySearch(unsortedNumbers, 4));
	}

	void understandingArrayList() {

		ArrayList<String> al1 = new ArrayList(java.util.Arrays.asList(new String[] { "asd", "asd", "asd", "asd" }));
		ArrayList<String> al2 = new ArrayList(al1);
		List<String> list1 = al1;
		System.out.println("al2.equals(al2) " + al2.equals(al2));
		list1.add("Add to list1");
		System.out.println(al1.get(0));
		System.out.println(al1.set(0, "0 is set"));
		System.out.println(al1.toString());

		System.out.println(al1.remove(2));
		try {

			System.out.println(al1.remove(200));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Error removing element from al1 " + e.getMessage());
		}
		System.out.println(al1.remove("fadfasfasfasasd"));
		System.out.println(al1.remove("asd"));
		System.out.println(al1.toString());
		al1.set(1, null);
		System.out.println(al1.isEmpty());
		System.out.println(al1.size());
		System.out.println(al1.contains("asd"));
		System.out.println(al1.contains("0 is set"));
		al1.clear();
		System.out.println(al1.size());
	}

	void wrapperClasses() {
		int primitiveInt1 = Integer.parseInt("1235");
		int wrapperInteger1 = Integer.valueOf("123");
		try {

			int primitiveInt2 = Integer.parseInt("a1235");
		} catch (NumberFormatException e) {
			System.out.println("Error parsing integer " + e.getMessage());
		}
		System.out.println("primitiveInt1 " + primitiveInt1);
		System.out.println("wrapperInteger1 " + wrapperInteger1);
		List<Double> doubleList1 = new ArrayList<>();
		doubleList1.add(10.54); // Autoboxes from primitive double to Double
		doubleList1.add(new Double(12));
		double firstItem = doubleList1.get(0);
		doubleList1.remove(new Double(10));
	}

	void datesAndTimes() {
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		LocalDate date1 = LocalDate.of(2019, Month.DECEMBER, 20);
		LocalDate date2 = LocalDate.of(2019, 12, 20);
		date2 = date2.plusDays(100000);
		System.out.println(date2);
		Period period = Period.ofYears(1000);
		Period p2 = Period.ofMonths(1).ofDays(20);
		p2 = Period.ofMonths(1);
		p2 = Period.ofDays(20);
		Period p3 = Period.of(100, 10, 10);
		date2 = date2.plus(p3);
		System.out.println(date2);
		LocalDate date = LocalDate.of(2015, 12, 7);
		LocalTime time = LocalTime.of(10, 30, 15);
		LocalDateTime dateTime=LocalDateTime.of(date, time);
		System.out.println(dateTime);
		DateTimeFormatter format=DateTimeFormatter.ISO_LOCAL_TIME;
		String dateTimeString=dateTime.format(format);
		System.out.println(dateTimeString);
		DateTimeFormatter format2=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		dateTimeString=dateTime.format(format2);
		System.out.println(dateTimeString);
		DateTimeFormatter customFormatter= DateTimeFormatter.ofPattern("MMMM dd,yyyy,hh:mm");
		System.out.println(dateTime.format(customFormatter));
		DateTimeFormatter parseFormatter=DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate parsedDate=LocalDate.parse("10.06.1999",parseFormatter);
		LocalTime parsedTime=LocalTime.parse("16:22");
		System.out.println(parsedDate+" "+parsedTime);
	}

}
