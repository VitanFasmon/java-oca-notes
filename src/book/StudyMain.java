package book;

import book.chapter1.Chapter1;
import book.chapter2.Chapter2;
import book.chapter3.Chapter3;
import book.chapter4.Chapter4;
import book.chapter5.Chapter5;
import book.chapter6.Chapter6;

public class StudyMain {
	public static void main(String[] args) {
		System.out.println("Main");
		new Chapter1();
		new Chapter2();
		new Chapter3();
		new Chapter4();
		new Chapter5();
		new Chapter6();
	}
}
