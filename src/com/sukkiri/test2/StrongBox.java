/**
 *
 */
package com.sukkiri.test2;

/**
 * @author user2
 *
 */
public class StrongBox<T> {
	private T content;
	private KeyType key;
	private int definedTimes;
	private int tryTimes;
	public static final int PADLOCK = 1024;
	public static final int BUTTON = 10000;
	public static final int DIAL = 30000;
	public static final int FINGER = 1000000;

	public StrongBox(KeyType key) {
		this.key = key;
	}

	public T get() {
		switch (this.key) {
		case PADLOCK:
			this.definedTimes = PADLOCK;
			break;
		case BUTTON:
			this.definedTimes = BUTTON;
			break;
		case DIAL:
			this.definedTimes = DIAL;
			break;
		case FINGER:
			this.definedTimes = FINGER;
		}

		if (tryTimes >= definedTimes) {
			return this.content;
		}

		this.tryTimes++;
		return null;
	}

	public void put(T content) {
		this.content = content;
	}
}
