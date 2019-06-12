/**
 *
 */
package com.sukkiri.test5;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author user2
 *
 */
public class Bank {
	String name;
	String adress;

	// equals 全てのfieldが等価の場合のメソッド
	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	// hasCodeの作成に全ての値を使用した自動生成
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
