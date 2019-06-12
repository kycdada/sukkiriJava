/**
 *
 */
package com.sukkiri.test2;

/**
 * @author user2
 *
 */
public class EnumAccount {
	private String accountNo;
	private int balance;
	private AccountType accountType;
	public static final int FUTSU = 1;
	public static final int TOUZA = 2;
	public static final int TEIKI = 3;

	enum AccountType {
		FUTSU, TOUZA, TEIKI
	}

	public EnumAccount(String accountNo, AccountType aType) {
		this.accountNo = accountNo;
		this.accountType = aType;
	}

}
