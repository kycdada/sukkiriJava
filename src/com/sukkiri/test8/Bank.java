/**
 *
 */
package com.sukkiri.test8;

/**
 * @author user2
 *
 */
public class Bank {
	private String name; // 銀行名(必ず3文字以上)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name == null) {
			name = "";
		}
		if (name.length() < 3) {
			throw new IllegalArgumentException("名前が不正です");
		}

		this.name = name;
	}

}
