/**
 *
 */
package com.sukkiri.test2;

/**
 * @author user2
 *
 */
public class Account implements Comparable<Account>, Cloneable {
	String accountNo; // 口座番号(先頭に空白が入ることもある)

	@Override
	public boolean equals(Object o) {

		// assertTEST
		// assert !(o instanceof Account) : "テスト";

		// this == 自分自身が引数
		if (o == this)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof Account))
			return false;
		Account r = (Account) o;
		if (!this.accountNo.trim().equals(r.accountNo.trim())) {
			return false;
		}
		return true;
	}

	// sortの自然順序付けを定義
	@Override
	public int compareTo(Account obj) {
		if (Integer.parseInt(this.accountNo) < Integer.parseInt(obj.accountNo)) {
			return -1;
		}
		if (Integer.parseInt(this.accountNo) > Integer.parseInt(obj.accountNo)) {
			return 1;
		}
		return 0;
	}

	public Account clone() {
		Account ac = new Account();
		ac.accountNo = this.accountNo;
		return ac;
	}
}
