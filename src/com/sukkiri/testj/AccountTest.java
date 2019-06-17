package com.sukkiri.testj;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.sukkiri.test2.Account;

public class AccountTest {
	@Test
	void equals確認1() throws Exception {
		Account ac = new Account();
		assertTrue(ac.equals(ac));
	}
}
