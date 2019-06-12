/**
 *
 */
package com.sukkiri.test3;

/**
 * @author user2
 *
 */
public class FuncList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Func1 func1 = FuncList::isOdd;
		FuncList funcList = new FuncList();
		Func2 func2 = funcList::addNamePrefix;
		System.out.println(func1.call(2));
		System.out.println(func2.call(false, "Yes"));

		func1 = (int x) -> {
			return (x % 2 == 1);
		};
		func2 = (boolean male, String name) -> {
			if (male == true) {
				return "Mr." + name;
			} else {
				return "Ms." + name;
			}
		};
		System.out.println(func1.call(5));
		System.out.println(func2.call(true, "No"));

	}

	public static boolean isOdd(int x) {
		return (x % 2 == 1);
	}

	public String addNamePrefix(boolean male, String name) {
		if (male == true) {
			return "Mr." + name;
		} else {
			return "Ms." + name;
		}
	}

	public interface Func1 {
		public abstract boolean call(int x);
	}

	public interface Func2 {
		public abstract String call(boolean male, String name);
	}

}
