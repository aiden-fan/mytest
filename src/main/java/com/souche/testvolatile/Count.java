package com.souche.testvolatile;

import java.util.UUID;

/***
 *@author fanmiao
 *@date 2020/6/4 6:05 下午 
 */
public class Count {
    private String  num;
    private volatile boolean flag;

    public void increase(int i) throws InterruptedException {
        if (!flag) {
            Thread.sleep(10L);
            num = getString();
            System.out.println("increase :" + num);
            flag = true;
        }
    }

    public String getString() {
        return UUID.randomUUID().toString();
    }

    public void print(int i) throws InterruptedException {
        if (flag) {
            Thread.sleep(10L);
            System.out.println(num);
            flag = false;
        }
    }


}
