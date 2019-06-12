/**
 *
 */
package com.sukkiri.test4;

/**
 * @author user2
 *
 */
public class RefTest {
	public int times = 0;

	public RefTest(int t) {
		this.times = t;
	}

	public void hello(String msg) {
		this.hello(msg, this.times);
	}

	public void hello(String msg, int t) {
		System.out.println("Hello," + msg + " x" + t);
	}
}
