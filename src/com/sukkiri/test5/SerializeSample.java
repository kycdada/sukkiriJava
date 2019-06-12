/**
 *
 */
package com.sukkiri.test5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author user2
 *
 */
public class SerializeSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// オブジェクトの直列化(serialization)
		// あるインスタンスの内容(全フィールド)をそのままバイト列に変換したり、その逆

		// インスタンスの直列化と保存
		SerializeClass sc = new SerializeClass();
		sc.setHp(12);
		try (FileOutputStream fos = new FileOutputStream("c:\\Users\\user2\\rpgtest.dat");
				BufferedOutputStream bof = new BufferedOutputStream(fos);
				ObjectOutputStream oops = new ObjectOutputStream(bof);) {
			oops.writeObject(sc);
			oops.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ファイルからインスタンスを復元
		try (FileInputStream fis = new FileInputStream("c:\\Users\\user2\\rpgtest.dat");
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis);) {
			SerializeClass ss = (SerializeClass) ois.readObject();
			System.out.println(ss.getName());
			System.out.println(ss.getHp());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
