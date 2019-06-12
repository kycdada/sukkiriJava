/**
 *
 */
package com.sukkiri.test4;

/**
 * @author user2
 *
 */
public class RefSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// リフレクションAPIを用いた型情報の取得
		Class<?> infos = String.class;
		System.out.println(infos.getSimpleName());
		System.out.println(infos.getName());
		System.out.println(infos.getPackage().getName());
		System.out.println(infos.isArray());

		// 親クラス
		Class<?> infosp = infos.getSuperclass();
		System.out.println(infosp.getName());

		// argは文字配列として判断される
		Class<? extends String[]> infoArg = args.getClass();
		System.out.println(infoArg.getName());
		System.out.println(infoArg.isArray());

	}

}
