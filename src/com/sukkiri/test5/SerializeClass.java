/**
 *
 */
package com.sukkiri.test5;

import java.io.Serializable;

/**
 * @author user2
 *
 */
public class SerializeClass implements Serializable {
	private String name = "test";
	private int hp = 1;
	private int mp = 2;
	// version管理用変更したら変更する(読みこんだファイルが旧バージョンのuuidだった場合エラー)
	private static final long serialVersionUID = 81555454;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return this.mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

}
