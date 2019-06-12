/**
 *
 */
package com.sukkiri.test;

import java.nio.charset.Charset;

/**
 * @author user2
 *
 */
public class Str {

	public static void main(String[] args) {
		String s1 = "スッキリJava";
		String s2 = "Java";
		String s3 = "java";
		if (s2.equals(s3)) {
			System.out.println("s2とs3は等しい");
		}
		if (s2.equalsIgnoreCase(s3)) {
			System.out.println("s2とs3はcaseを区別しなければ等しい");
		}
		System.out.println("s1の長さは" + s1.length() + "です。");
		if (s1.isEmpty()) {
			System.out.println("s1は空文字です。");
		}

		s1 = "Java and JavaScript";
		if (s1.contains("Java")) {
			System.out.println("文字列s1はJavaを含んでいます。");
		}
		if (s1.endsWith("Java")) {
			System.out.println("文字列s1はjavaが末尾にあります。");
		}
		System.out.println("文字列s1で最初にJavaが表示される位置は" + s1.indexOf("Java"));
		System.out.println("文字列s1で最後にJavaが表示される位置は" + s1.lastIndexOf("Java"));

		s1 = "Java programming";
		System.out.println("s1の三文字目以降は" + s1.substring(3));
		System.out.println("s1の3～8文字目は" + s1.substring(3, 8));

		// 文字列を連結したり更新したりを度々するならStringBuilder + は遅い(String インスタンスは不変 StringBuilderは可変)
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append("Java");
		}
		// 完成した文字列を取り出す (StringBuilderのままでも処理が出来ないわけではない)
		String s = sb.toString();
		System.out.println(s);

		// メソッドチェーン(appendが自分自身への参照を返しているため可能)
		StringBuffer sb2 = new StringBuffer();
		sb2.append(s1).append(s2).append(s3);
		System.out.println(sb2);

		// 文字列を一文字づづ処理したいとき → char配列
		String str = "こんにちはJava";
		char[] data1 = str.toCharArray();
		// 文字列情報を指定した文字コードで書き込む時などに利用する。
		byte[] data2 = str.getBytes(); // default文字コード
		byte[] data3 = str.getBytes(Charset.forName("utf-8"));

		// char配列やbyte配列をString変換(コンストラクタに渡す)
		String string = new String(data1);

		// 正規表現match
		String valStr = "JAVA4551";
		Str test = new Str();
		System.out.println(test.isVaildPlayerName(valStr));

		// split
		s1 = "rururu,rururu:rururu";
		String[] words = splitString(s1);
		for (String word : words) {
			System.out.println(word);
		}

		// replaceAll
		StringBuilder sbt = new StringBuilder(replaceAll(s1, "[u]+", "t"));
		System.out.println(sbt);

		// format
		String formatString = String.format("%05d  %4S %-7b", 54, "で", true);
		System.out.println(formatString);

		// str練習問題1-1
		StrTest st = new StrTest();
		st.makeNum();

		// str練習問題-2
		st.connectFileName("C:\\user\\", "robot.text");

	}

	private boolean isVaildPlayerName(String name) {
		// 最初大文字英、他大文字英数字　合計8文字
		return name.matches("[A-Z][A-Z0-9]{7}");
	}

	private static String[] splitString(String str) {
		// カンマorコロンでsplit
		return str.split("[,:]");
	}

	private static String replaceAll(String str, String beforeReplace, String afterReplace) {
		// 文字列置き換えメソッド
		return str.replaceAll(beforeReplace, afterReplace);
	}

}

class StrTest {
	public void makeNum() {
		StringBuilder sbt = new StringBuilder();
		for (int i = 1; i <= 100; i++) {
			sbt.append(Integer.toString(i));
			if (i < 100) {
				sbt.append(",");
			}
		}
		System.out.println(sbt);
		String[] strSplit = sbt.toString().split(",");
		for (String string : strSplit) {
			System.out.println(string);
		}
	}

	public void connectFileName(String folderName, String fileName) {
		if (!folderName.endsWith("\\")) {
			folderName += "\\";
		}
		System.out.println(folderName + fileName);
	}
}
