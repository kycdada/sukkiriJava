/**
 *
 */
package com.sukkiri.test5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Properties;

/**
 * @author user2
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "c:\\Users\\user2\\pref.properties";
		try (FileOutputStream fop = new FileOutputStream(path);
				BufferedOutputStream bof = new BufferedOutputStream(fop);) {
			Properties p = new Properties();
			p.setProperty("tokyo.capital", "Tokyo");
			p.setProperty("tokyo.food", "寿司");
			p.setProperty("aichi.capital", "名古屋");
			p.setProperty("aichi.food", "味噌カツ");
			p.storeToXML(bof, "練習問題10-1", "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileInputStream fis = new FileInputStream(path);
				BufferedInputStream bos = new BufferedInputStream(fis)) {
			Properties p = new Properties();
			p.loadFromXML(bos);
			String capital = p.getProperty("aichi.capital");
			String food = p.getProperty("aichi.food");
			System.out.println(capital + ":" + food);

		} catch (IOException e) {
			e.printStackTrace();
		}

		Employee tanaka = new Employee();
		tanaka.Name = "田中太郎";
		tanaka.age = 41;

		Department tanakaDepartment = new Department();
		tanakaDepartment.name = "総務部";
		tanakaDepartment.leader = tanaka;

		try (FileOutputStream fiot = new FileOutputStream("c:\\Users\\user2\\company.dat");
				BufferedOutputStream bosd = new BufferedOutputStream(fiot);
				ObjectOutputStream oos = new ObjectOutputStream(bosd);) {
			oos.writeObject(tanakaDepartment);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class Employee implements Serializable {
	String Name;
	int age;
}

class Department implements Serializable {
	String name;
	Employee leader;
}
