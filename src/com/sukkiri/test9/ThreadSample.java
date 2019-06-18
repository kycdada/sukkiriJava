/**
 *
 */
package com.sukkiri.test9;

import java.util.Scanner;

/**
 * @author user2
 *
 */
public class ThreadSample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("何か入力してください");
        Thread t = new printingThread();
        // run()ではなく、start
        t.start();
        new Scanner(System.in).nextLine();

    }

}

/**
 * 別スレッドの処理内容
 *
 */
class printingThread extends Thread {
    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
    }

}
