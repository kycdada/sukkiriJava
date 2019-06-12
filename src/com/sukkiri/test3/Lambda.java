/**
 *
 */
package com.sukkiri.test3;

import java.util.function.IntBinaryOperator;

/**
 * @author user2
 *
 */
public class Lambda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntBinaryOperator func = (int a, int b) -> {
			return a - b;
		};
		int division = func.applyAsInt(78, 42);
		System.out.println("78-42は" + division);
	}
}
