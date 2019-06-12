/**
 *
 */
package com.sukkiri.test3;

import java.util.function.IntBinaryOperator;

/**
 * @author user2
 *
 */
public class FunctionExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//subメソッドの処理を変数funcにいれる(関数のある参照先をいれるイメージ)
		// IntBinaryOperator interface 二つのintオペラントに作用してint値の結果を生成する演算を表します。
		IntBinaryOperator func = FunctionExam::sub;
		int a = func.applyAsInt(5, 3); // 二つのintオペラントに作用してint値の結果を生成(関数呼び出し)
		System.out.println(a);

		Myfunction func2 = FunctionExam::sub;
		a = func2.call(7, 6);
		System.out.println(a);
	}

	public static int sub(int a, int b) {
		return a - b;
	}

	// 格納用SAMインターフェース(java.utill.functionパッケージ内にない場合このように作成する)
	public interface Myfunction {
		public abstract int call(int x, int y);
	}

}
