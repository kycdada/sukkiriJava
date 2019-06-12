/**
 *
 */
package com.sukkiri.test4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * @author user2
 *
 */
public class JVMTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		boolean finish = true;
		if (finish == false) {
			// JVM強制終了
			System.out.println("終了");
			System.exit(1);
		}
		System.out.println("動作");

		// 外部プログラム呼び出し
		ProcessBuilder pb = new ProcessBuilder(
				"c:\\windows\\system32\\notepad.exe",
				"calcreport.txt");
		pb.start();

		// システムプロパティの取得
		System.out.println("ご利用のJavaバージョン:");
		System.out.println(System.getProperty("java.version"));
		// システムプロパティの設定
		System.setProperty("rpg", "3");
		Properties p = System.getProperties();
		Stream<String> nameStream = p.stringPropertyNames().stream();

		System.out.println("[システムプロパティ一覧]");

		nameStream.forEach(propertyKey -> {
			System.out.print(propertyKey + " = ");
			System.out.println(System.getProperty(propertyKey));
		});

		// 改行文字を実行環境に合わせる \r or \n
		final String BR = System.getProperty("line.separator");
		System.out.println("本日は" + BR + "晴天なり");

		// メモリ
		long f = Runtime.getRuntime().freeMemory();
		System.out.println(f);

		// リフレクションAPI
		Class clazz = RefTest.class;
		// 引数が一つのコンストラクタを取得し、インスタンスを生成する
		Constructor<?> cons = clazz.getConstructor(int.class);
		RefTest rs = (RefTest) cons.newInstance(256);
		// timesフィールドに関するFieldを取得して読み書き
		Field field = clazz.getField("times");
		field.set(rs, 2);
		System.out.println(field.get(rs));
		// 引数2つのhelloメソッドを取得して読み書き
		Method m = clazz.getMethod("hello", String.class, int.class);
		m.invoke(rs, "reflection", 128);
		// クラスやメソッドへの修飾(publicやfinalの有無)を調べる
		boolean pubc = Modifier.isPublic(clazz.getModifiers());
		boolean finm = Modifier.isFinal(m.getModifiers());

	}

}
