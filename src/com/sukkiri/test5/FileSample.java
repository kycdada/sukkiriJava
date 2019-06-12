/**
 *
 */
package com.sukkiri.test5;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author user2
 *
 */
public class FileSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// FileWrite
		try (FileWriter fw = new FileWriter("c:\\Users\\user2\\test.dat", true)) {

			fw.write("S");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// File Read
		try (FileReader fr = new FileReader("c:\\Users\\user2\\test.dat");) {
			int i = fr.read(); // 一文字読み込む
			while (i != -1) {
				char c = (char) i;
				System.out.println(c);
				i = fr.read();
			}
		} catch (

		IOException e) {
			e.printStackTrace();
		}
		System.out.println("ファイルの末尾に到達しました");

		// FileOutPutStream
		try (FileOutputStream fos = new FileOutputStream("c:\\Users\\user2\\test2.dat", true);) {
			fos.write(65); // 01000001= A
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// StringReader String型変数から一文字づづ読み取る
		String msg = "第一土曜";
		try (
				Reader sr = new StringReader(msg);) {
			char c1 = (char) sr.read();
			char c2 = (char) sr.read();
			System.out.println(String.valueOf(c1) + String.valueOf(c2));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Byte配列に値を書き込む
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(65);
		baos.write(66);
		// 書き込んだStreamからbyte配列を取得
		byte[] data = baos.toByteArray();
		String bstr = new String(data);
		System.out.println(bstr);

		// BufferedReader
		try (
				FileReader fr2 = new FileReader("\\Users\\user2\\test.dat");
				BufferedReader br = new BufferedReader(fr2);) {
			String line = null;
			while ((line = br.readLine()) != null) {
				/* lineを使った処理() */
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
