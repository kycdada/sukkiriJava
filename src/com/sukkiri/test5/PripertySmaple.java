/**
 *
 */
package com.sukkiri.test5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author user2
 *
 */
public class PripertySmaple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (FileOutputStream fo = new FileOutputStream("c:\\Users\\user2\\test.properties");) {
			// property file 書き込み
			Properties p = new Properties();

			p.setProperty("HeroName", "test");
			p.setProperty("HP", "無限");
			p.setProperty("MP", "無限大");
			p.storeToXML(fo, "test情報", "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileInputStream fi = new FileInputStream("c:\\Users\\user2\\test.properties");) {
			Properties p = new Properties();
			p.loadFromXML(fi);
			String name = p.getProperty("HeroName");
			String hp = p.getProperty("HP");
			String mp = p.getProperty("MP");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
