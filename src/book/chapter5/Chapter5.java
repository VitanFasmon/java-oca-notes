package book.chapter5;

public class Chapter5 {
	public Chapter5() {
		System.out.println("_______________________________________");
		System.out.println("Chapter5");
		introducingInheritance();
		interfaces();
		polymorphism();
	}

	void introducingInheritance() {
		Lion simba = new Lion();
		// simba.setAge(25);
		simba.roar();
		System.out.println("Simba is " + (simba.alive ? "alive" : "dead"));
		simba.alive = false;
		System.out.println("Simba is " + (simba.alive ? "alive" : "dead"));
		Animal a = new Animal(234);
		System.out.println("Animal age: " + a.getAge());
		Chimpanzee c = new Chimpanzee();
		Canine cn = new Canine();
		System.out.println(cn.getAverageWeight());
		Wolf w = new Wolf();
		System.out.println(w.getAverageWeight());
		BactrianCamel camel = new BactrianCamel();
		camel.getNumberOfHumps();
		System.out.println(camel.getNumberOfHumps());
		Bear.eat();
		Panda.eat();
		Kangoroo kan = new Kangoroo();
		kan.getMarsupialDescription();
		kan.getKangorooDescriptopn();
		Rodent rodent = new Rodent();
		Mouse mouse = new Mouse();
		Rodent rodentMouse = new Mouse();

		rodent.getRodentDetails();
		mouse.getMouseDetails();
		rodentMouse.getRodentDetails();

	}

	void interfaces() {
		MySeal seal = new MySeal();
		System.out.println(seal.isMammal);
		Hop.getJumpHeight();
	}

	void polymorphism() {
		MySeal seal = new MySeal();
		Lemur lemur = new Lemur();
		System.out.println(lemur.age);
		HasTail2 hasTail2 = lemur;
		System.out.println(hasTail2.isTailStriped());
		Primate2 primate2 = lemur;
		System.out.println(primate2.hasHair());
		Object lemurObject = lemur;
		Rodent2 rodent = new Rodent2();
		if (rodent instanceof Capybara) {
			// it's not
			Capybara capybara = (Capybara) rodent;
		}
		try {
			Lemur newLemur = (Lemur) lemurObject;
			Capybara capybara = (Capybara) rodent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		Bird2 bird = new Peacock();
		bird.displayInformation();
		ZooWorker worker=new ZooWorker();
		Alligator gator=new Alligator();
		Crocodile crock=new Crocodile();
		worker.feed(gator);
		worker.feed(crock);
	}

}

class Animal {
	private int age;
	boolean alive;

	public Animal() {
		this(5);
	}

	public Animal(int age) {
		this.age = age;
		this.alive = true;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Lion extends Animal {
	public Lion() {
		super(10);
	}

	public Lion(int age) {
		super(age);
	}

	public void roar() {
		System.out.println("Lion age: " + this.getAge());
	}
}

class Primate {
	public Primate() {
		System.out.println("Primate");
	}
}

class Ape extends Primate {
	public Ape() {
		System.out.println("Ape");
	}
}

class Chimpanzee extends Ape {

}

class Canine {
	double getAverageWeight() {
		return 50;
	}
}

class Wolf extends Canine {
	double getAverageWeight() {
		return super.getAverageWeight() + 20;
	}
}

class Camel {
	protected String getNumberOfHumps() {
		return "Undefined";
	}
}

class BactrianCamel extends Camel {
	// private int getNumberOfHumps() {return 2;} //does not compile because it is
	// not as accessible as the parent and not the same return type

	protected String getNumberOfHumps() {
		return "Two";
	}
}

class InsufficientDataException extends Exception {
}

class Reptile {
	protected double getHeight() {
		return 2;
	}

	protected double getLength() {
		return 10;
	}

	protected boolean hasLegs() throws InsufficientDataException {
		throw new InsufficientDataException();
	}

	protected double getWeight() throws Exception {
		return 2;
	}

}

class Snake extends Reptile {
	protected double getHeight() {
		return 2;
	}

	protected double getLength() {
		return 10;
	}

	protected boolean hasLegs() {
		return false;
	}

	protected double getWeight() throws InsufficientDataException {
		return 2;
	}
}

class Bear {
	static void eat() {
		System.out.println("Bear eating...");
	}

	static void sneeze() {
		System.out.println("Bear sneazing...");
	}

	void hibernate() {
		System.out.println("Bear hibernating...");
	}
}

class Panda extends Bear {
	static void eat() {
		System.out.println("Panda is eating...");
	}
}

class PolarBear extends Bear {
	static void eat() {
		System.out.println("Polar bear is eating...");
	}

	static void sneeze() {
		System.out.println("Polar bear  sneazing...");
	}

	void hibernate() {
		System.out.println("Polar bear  hibernating...");
	}
}

class Marsupial {
	static boolean isBiped() {
		return false;
	}

	void getMarsupialDescription() {
		System.out.println("Marsupial walks on two legs: " + isBiped());
	}
}

class Kangoroo extends Marsupial {
	static boolean isBiped() {
		return true;
	}

	void getKangorooDescriptopn() {
		System.out.println("Kangoroo hops on two legs: " + isBiped());
	}
}

class Bird {
	final boolean hasFeathers() {
		return true;
	}
}

class Penguin extends Bird {
	boolean hasFeathers2() {
		return false;
	}
}

class Rodent {
	protected static int tailLength = 4;

	static void getRodentDetails() {
		System.out.println("parent tail= " + tailLength);
	}
}

class Mouse extends Rodent {
	protected static int tailLength = 8;

	static void getRodentDetails() {
		System.out.println("tail= " + tailLength);
	}

	void getMouseDetails() {
		System.out.println("mouse tail= " + tailLength + ", parent tail= " + super.tailLength);
	}
}

abstract class AbstractAnimal {
	protected int name;

	void eat() {
		System.out.println("Animal is eating...");
	}

	abstract String getName();
}

class Swan extends AbstractAnimal {
	String getName() {
		return "Swan";
	}
}

abstract class Whale {
	abstract void sing(); // if this was private, how could the HumpbackWhale access it?
}

class HumpbackWhale extends Whale {
	void sing() {
		System.out.println("singing...");
	}
}

abstract class AbstractMammal extends AbstractAnimal {
	abstract void printNumberOfLegs();

	boolean drinksMilk() {
		return true;
	}

}

class Rabbit extends AbstractMammal {

	@Override
	void printNumberOfLegs() {
		// TODO Auto-generated method stub

	}

	@Override
	String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}

abstract interface MyInterface {
	public static final int MINIMUM = 2;

	public abstract int getMax();
}

interface HasTail {
	int getTailLength();
}

interface HasWhiskers {
	int gerNumberOfWhiskers();
}

interface Seal extends HasTail, HasWhiskers {
	static final boolean isMammal = true;

	String getSealName();
}

class MySeal implements Seal {

	@Override
	public int getTailLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int gerNumberOfWhiskers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSealName() {
		// TODO Auto-generated method stub
		return null;
	}

}

interface Herbivore {
	void eatPlants();
}

interface Omnivore {
	void eatPlants();

	void eatMeat();
}

class Bear2 implements Herbivore, Omnivore {

	public void eatMeat() {
		// TODO Auto-generated method stub
	}

	public void eatPlants() {
		// TODO Auto-generated method stub
	}
}

interface IsWarmBlooded {
	boolean hasScales();

	default double getTemperature() {
		return 10.0;
	}
}

interface HasFins {
	default int getNumberOfFins() {
		return 4;
	}

	default double getLongetFinLength() {
		return 20.0;
	}

	default boolean doFinsHaveScales() {
		return true;
	}
}

interface SharkFamily extends HasFins {
	default int getNumberOfFins() {
		// TODO Auto-generated method stub
		return 8;
	}

	double getLongestFinLength();

	default boolean doFinsHaveScales() {
		return true;
	}
}

interface Walk {
	default int getSpeed() {
		return 5;
	}
}

interface Run {
	default int getSpeed() {
		return 10;
	}
}

class Cat implements Walk, Run {
	public int getSpeed() {
		return 1;
	}
}

interface Hop {
	static int getJumpHeight() {
		return 8;
	}
}

class Primate2 {
	boolean hasHair() {
		return true;
	}
}

interface HasTail2 {
	boolean isTailStriped();
}

class Lemur extends Primate2 implements HasTail2 {
	public boolean isTailStriped() {
		return true;
	}

	int age = 10;
}

class Rodent2 {
}

class Capybara extends Rodent2 {

}

class Bird2 {
	String getName() {
		return "unknown";
	}

	void displayInformation() {
		System.out.println("the bird name is " + getName());
	}
}

class Peacock extends Bird2 {
	String getName() {
		return "Peacock";
	}
}

class Reptile2 {
	String getName() {
		return "Reptile";
	}
}
class Alligator extends Reptile2{
	String getName() {
		return "alligator";
	}
}
class Crocodile extends Reptile2{
	String getName() {
		return "crockodile";
	}
}
class ZooWorker{
	static void feed(Reptile2 reptile) {
		System.out.println("Feeding reptile "+reptile.getName());
	}
}











