package book.chapter4;

import java.util.ArrayList;
import java.util.List;

import book.chapter4.accessModifiers.Bird;

public class Chapter4 {
	public Chapter4() {
		System.out.println("_______________________________________");
		System.out.println("Chapter4");
		varargs();
		accessModifiers();
		staticVariablesAndMethods();
		methodOverloading();
		lambdas();
	}

	private void varargs() {
		String[] data = { "123", "12asdasd3", "1adsasdas23", "12asd3", "123asd" };
		varargExample1(12, null);
		varargExample1(12, data);
		varargExample1(12, "asdasd", "asdasd", "asdasd", "asdasd", "asdasd");
	}

	private void varargExample1(int number, String... args) {
		if (args == null || args.length == 0) {
			System.out.println("NO ARGS. Number: " + number);
			return;
		}
		for (String argument : args) {
			System.out.println(argument);
		}
	}

	void accessModifiers() {
		Swan s1 = new Swan();
		s1.helpOtherSwanSwim();
	}

	class Swan extends Bird {
		public void swim() {
			floatInWater();
			System.out.println(text);
		}

		public void helpOtherSwanSwim() {
			Swan other = new Swan();
			other.floatInWater();
			System.out.println(other.text);
		}

		public void helpOtherBirdSwim() {
			Bird otherBird = new Bird();
			// otherBird.floatInWater();
			// otherBird.text
		}
	}

	class Goose extends Bird {
		public void helpGooseSwim() {
			Goose other = new Goose();
			other.floatInWater();
			System.out.println(other.text);
		}

		public void helpOtherBirdSwim() {
			Bird other = new Goose();
			// other.floatInWater();
		}
	}

	static class Koala {
		static int count = 0;
		static final int ID_NUMBER = 123;
		static final ArrayList<String> koalaNames = new ArrayList<>();

		static void main(String[] args) {
			System.out.println("Main koala.");
		}
	}

	void staticVariablesAndMethods() {
		Koala k = new Koala();
		Koala k2 = new Koala();
		Koala k3 = new Koala();
		k.main(null);
		System.out.println(k.count);
		k.count = 8;
		k = null;
		System.out.println(k.count);
		k3.count = 9999;
		System.out.println(k.count);
		System.out.println(k.koalaNames.toString());
		// k.koalaNames=new ArrayList(); //DOES NOT COMPILE
		k.koalaNames.add("Liska");
		;
		System.out.println(k.koalaNames.toString());

	}

	private static final int NUM_SECONDS_PER_HOUR;
	static {
		int NUM_SECONDS_PER_MINUTE = 60;
		int NUM_MINUTES_PER_HOUR = 60;
		NUM_SECONDS_PER_HOUR = NUM_SECONDS_PER_MINUTE * NUM_MINUTES_PER_HOUR;
	}

	class Overloading {
		int a, b, c;
		final int z;

		public Overloading() {
			this(999);
		}

		public Overloading(int a) {
			this(a, 999);
		}

		protected Overloading(int a, int b) {
			this(a, b, 999);

		}

		Overloading(int a, int b, int c) {
			this.b = b;
			this.a = a;
			this.c = c;
			z = a + b + c;
		}

		Overloading(String name) throws Exception {
			System.out.println(name);
			z = 0;
		}

		void print() {
			System.out.println("a: " + a + " b: " + b + ", c: " + c);

		}

		public int fly(int miles) {
			System.out.println("int");
			return miles;
		}

		public int fly(Integer miles) {
			System.out.println("Integer");
			return miles;
		}

		public void fly() {
			System.out.println("empty");

		}

		public void fly(String s) {
			System.out.println("string");
		}

		public void fly(Object o) {
			System.out.println("object");

		}

		// public void fly(int miles) { } does not compile becouse of the same
		// parameters
	}

	void methodOverloading() {
		Overloading o = new Overloading();
		new Overloading().print();
		new Overloading(1).print();
		new Overloading(1, 2).print();
		new Overloading(1, 2, 3).print();
		try {
			new Overloading("NAME AKSDKASLDKPASKPD").print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		o.fly();
		o.fly(12);
		o.fly((int) 12892348938902L);
		o.fly(new Integer(45));
		o.fly("Stringasdasd");
		o.fly(12.6);
		o.fly(false);

	}

	void lambdas() {
		System.out.println("LAMBDAS");
		// lets test if animal can hop
		Animal kangoroo = new Animal("Kangoroo", true, false);
		System.out.println(new CheckIfCanHop().test(kangoroo));
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("Kangoroo", true, false));
		animals.add(new Animal("fish", false, true));
		animals.add(new Animal("Rabbit", true, false));
		animals.add(new Animal("Human", true, true));
		printAnimals(animals, new CheckIfCanHop());
		System.out.println("______");
		printAnimals(animals, a -> a.canHop());
		System.out.println("______");
		printAnimals(animals, a -> a.canSwim());
		System.out.println("______");
		printAnimals(animals, a -> true);
		System.out.println("______");
		printAnimals(animals, a -> Boolean.FALSE);
		System.out.println("______");
		animals.forEach((Animal animal) -> {
			System.out.println(animal.toString());
			int i = 0;
		});
		lambdaPracticeMethod((boolean b) -> b ? 1 : 0);
		// lambdaPracticeMethod((boolean b)->{b=true; boolean b=false; return 2;}); //
		// DOES NOT COMPILE. We cannot redeclare local variable b
		animals.removeIf((a)->a.canSwim());
		animals.forEach((Animal animal) -> {
			System.out.println(animal.toString());
			int i = 0;
		});
	}

	void printAnimals(List<Animal> animals, CheckTrait checker) {
		for (Animal animal : animals) {
			System.out.print(animal.toString() + " ");
			System.out.println(checker.test(animal));
		}
	}
	

	void lambdaPracticeMethod(LambdaPractice interf) {
		System.out.println(interf.intReturner(false));

	}
}

interface LambdaPractice {
	int intReturner(boolean bool);
}

class CheckIfCanHop implements CheckTrait {
	public boolean test(Animal a) {
		return a.canHop();
	};
}

interface CheckTrait {
	boolean test(Animal a);
}

class Animal {
	private String species;
	private boolean canHop;
	private boolean canSwim;

	public Animal(String speciesName, boolean hopper, boolean swimmer) {
		species = speciesName;
		canHop = hopper;
		canSwim = swimmer;
	}

	public boolean canHop() {
		return canHop;
	}

	public boolean canSwim() {
		return canSwim;
	}

	public String toString() {
		return species;
	}

}
