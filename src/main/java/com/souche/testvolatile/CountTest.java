package com.souche.testvolatile;

/***
 *@author fanmiao
 *@date 2020/6/4 6:08 下午 
 */
public class CountTest {
    public static void main(String[] args) {
        Count count = new Count();

        Thread thread = new Thread(() -> {
            for (; ;) {
                try {
                    count.increase(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread1 = new Thread(() -> {
            int i = 0;
            for (; ; ) {
                try {
                    count.print(++i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread1.start();


    }
}
