package test;

public class Person {

	private String name = "tom";
	private static int count = 20;

	class PersonOperator {

		public void showPersonName() {
			Person p = new Person();
			System.out.println(p.name);
		}

	}

	public static void test() {

	}

	static class Inner {
		public void print() {
			System.out.println(count);
			// System.out.println(name);
		}
	}

}
