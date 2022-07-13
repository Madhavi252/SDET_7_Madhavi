package practiceprograms;

public class SingleTon {

	// private static SingleTon s;

	private SingleTon(String name) {
		System.out.println(name);
	}

	public void add(int a, int b) {
		System.out.println(a + b);
	}

	public static SingleTon accessClass() {
		SingleTon s = new SingleTon("TYSS");
		return s;
	}
}
