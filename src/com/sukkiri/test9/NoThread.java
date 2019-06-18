/**
 *
 */
package com.sukkiri.test9;

import java.util.Scanner;

/**
 * @author user2
 *
 */
public class NoThread {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("何か入力してください");
        // ここで止まる
        new Scanner(System.in).nextLine();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

}
