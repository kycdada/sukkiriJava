/**
 *
 */
package com.sukkiri.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author user2
 *
 */
public class Cllectionetc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// colection
		// ArrayList
		List<Integer> points = new ArrayList<>();
		points.add(10);
		points.add(20);
		points.add(75);
		for (int i : points) {
			System.out.println(i);
		}

		List<String> names = new ArrayList<>();
		names.add("湊");
		names.add("朝霞");
		names.add("葦原");
		Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			String e = it.next();
			System.out.println(e);
		}
		//Set
		Set<String> colors = new HashSet<String>();
		colors.add("赤");
		colors.add("青");
		colors.add("黄");
		colors.add("赤");
		System.out.println("色は" + colors.size() + "種類");
		for (String s : colors) {
			// 順序は保証されない
			System.out.println(s);
		}
		Set<String> words = new TreeSet<String>();
		words.add("dog");
		words.add("cat");
		words.add("wolf");
		words.add("panda");
		for (String s : words) {
			System.out.print(s + "→");
		}
		// Map
		Map<String, Integer> prefs = new HashMap<>();
		prefs.put("京都府", 255);
		prefs.put("東京都", 255);
		prefs.put("熊本県", 161);
		int tokyo = prefs.get("東京都");
		System.out.println("\n東京都の人口は" + tokyo);
		prefs.remove("京都府");
		int kumamoto = prefs.get("熊本県");
		System.out.println("熊本県の人口は" + kumamoto);

		for (String key : prefs.keySet()) {
			int value = prefs.get(key);
			System.out.println(key + "の人口は、" + value);
		}
		// collectionの中身は参照型、
		// 入れる前のもの、取り出したものを変更したらリストの中身も変わる。
		Hero h = new Hero("ミナト");
		List<Hero> list = new ArrayList<>();
		list.add(h);
		h.name = "スガワラ";
		System.out.println(list.get(0).name);

		// test
		Test test = new Test();
		test.test2();
		test.test3();
	}
}

class Hero {
	public String name;

	public Hero(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}

class Test {
	public void test2() {
		Hero saito = new Hero("斎藤");
		Hero suzuki = new Hero("鈴木");
		List<Hero> list = new ArrayList<>();
		list.add(saito);
		list.add(suzuki);
		for (Hero hero : list) {
			System.out.println(hero.name);
		}
	}

	public void test3() {
		Hero saito = new Hero("斎藤");
		Hero suzuki = new Hero("鈴木");
		Map<Hero, Integer> map = new HashMap<>();
		map.put(saito, 3);
		map.put(suzuki, 7);
		for (Hero key : map.keySet()) {
			int value = map.get(key);
			System.out.println(key.getName() + "が倒した敵=" + value);
		}
	}
}
