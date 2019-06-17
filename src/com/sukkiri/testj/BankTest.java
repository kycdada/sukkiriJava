/**
 *
 */
package com.sukkiri.testj;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sukkiri.test8.Bank;

/**
 * @author user2
 *
 */
class BankTest {
	private Bank bank;

	@BeforeEach
	public void initialize() {
		bank = new Bank();

	}

	@Test
	void 銀行名三文字() throws Exception {
		// 正常系
		bank.setName("hao");
		assertEquals(bank.getName(), "hao");

	}

	@Test
	void 銀行名setNull時() throws Exception {
		//null時
		assertThrows(IllegalArgumentException.class, () -> {
			bank.setName(null);
		});
	}

	@Test
	void 銀行名error() throws Exception {
		// 異常系
		assertThrows(IllegalArgumentException.class, () -> {
			bank.setName("異常");
		});

	}

}
