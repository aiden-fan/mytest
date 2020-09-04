package com.souche.thread;

import lombok.SneakyThrows;

/***
 *@author fanmiao
 *@date 2020/3/17 9:02 下午 
 */
public class ExtendThread extends Thread {

    @SneakyThrows
    @Override
    public void run() {
        this.wait();
        String name = this.getName();
        for (int i = 0; i < 100; i++) {
            System.out.println(i+name);
        }
    }
}
