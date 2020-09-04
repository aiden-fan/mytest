package com.souche.thread;

import lombok.SneakyThrows;

/***
 *@author fanmiao
 *@date 2020/3/17 9:11 下午 
 */
public class ImplThread implements Runnable {
    @SneakyThrows
    @Override
    public void run() {
        synchronized (Object.class) {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(100L);
                System.out.println(i);
            }
        }
    }
}
