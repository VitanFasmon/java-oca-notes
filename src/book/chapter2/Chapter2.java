package book.chapter2;

public class Chapter2 {
	public Chapter2() {
		System.out.println("Chapter2");
		numericPromotion();
		unaryOpertors();
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
}
