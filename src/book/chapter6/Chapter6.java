package book.chapter6;

import java.io.FileReader;
import java.io.IOException;

public class Chapter6 {
	public Chapter6() {
		System.out.println("_______________________________________");
		System.out.println("Chapter6");
		try {
			nullPointerExceptionMethod(new Object[] { null });
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		arithmeticExceptionMethod();
		arrayIndexOutOfBoundsExceptionMethod();
		classCastExceptionMethod();
		visitZoo();
		twoExceptions();
		System.out.println(exceptions());
	}

	void nullPointerExceptionMethod(Object[] array) throws NullPointerException {
		if (array.length > 0) {
			System.out.println(array[0].toString());
		}
	}

	void arithmeticExceptionMethod() {
		try {
			System.out.println(5 / 0);
		} catch (ArithmeticException e) {
			e.printStackTrace();
			// throw new NullPointerException("NEW EXCEPTION");
		} finally {
			System.out.println("Finally runs even if the exception runs");
		}
	}

	void arrayIndexOutOfBoundsExceptionMethod() {
		String[] array = new String[0];
		try {
			System.out.println(array[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	void classCastExceptionMethod() {
		Parent parent = new Parent();
		try {
			Child child = (Child) parent;
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	}

	void visitZoo() {
		try {
			throw new ExhibitClosedForLunch();
		} catch (AnimalsOutForAWalk e) {
			System.out.println("Try later");
		} catch (ExhibitClosedForLunch e) {
			System.out.println("after lunch");
		} catch (ExhibitClosed e) {
			System.out.println("not today");
		}
	}

	void readFile() {
		FileReader reader = null;
		try {
			reader = read();
		} catch (IOException e) {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException inner) {
			}
		}
	}

	void twoExceptions() {
		try {
			throw new RuntimeException("try exception");
		} catch (RuntimeException e) {
			e.printStackTrace();
			//throw new RuntimeException("catch exception");
		} finally {
			// throw new RuntimeException("finally exception");
		}
	}

	String exceptions() {
		// before catch finally done
		String result = "";
		String v = null;
		try {
			try {
				result += "before ";
				v.length();
				result += "after ";
			} catch (NullPointerException e) {
				result += "catch ";
				throw new RuntimeException();
			} finally {
				result += "finally ";
				throw new Exception();
			}
		} catch (Exception e) {
			result += "done ";
		}
		return result;
	}

	FileReader read() throws IOException {
		return null;
	}

}

class AnimalsOutForAWalk extends RuntimeException {
}

class ExhibitClosed extends RuntimeException {
}

class ExhibitClosedForLunch extends ExhibitClosed {
}

class Parent {
}

class Child extends Parent {
}
