/**
 *
 */
package com.sukkiri.test2;

/**
 * @author user2
 *
 */
public class Hero implements Cloneable {
	private String name;
	private int hp, mp;
	Account account;

	// 新たにクラスを作成したら、親クラス（objectのtoString 及び equals 及び hashCode）をオーバーライドして上げる。
	// 親クラスの方のmethodが優先されて、想定道理に動かない可能性があるため

	// overrideしていなかった場合に、コンパイルエラーが出るアノテーション
	@Override
	public String toString() {
		return "勇者(名前)=" + this.name + "/HP" + this.hp + "/MP=" + this.mp + ")";
	}

	// cloneを可能にするために、interface追加しcloneメソッド作成
	// Cloneableはメソッドを一つも所持していない（アノテーション@overrideはつかえない?）
	// こういうのをmarker Interface
	public Hero clone() {
		Hero result = new Hero();
		result.name = this.name;
		result.hp = this.hp;
		result.mp = this.mp;
		// 浅いコピー（参照先は変わっていない）
		result.account = this.account;
		// 深いコピー（参照先が変わる）
		result.account = this.account.clone();

		return result;
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
