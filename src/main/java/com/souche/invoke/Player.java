package com.souche.invoke;

/***
 *@author fanmiao
 *@date 2020/4/2 4:01 下午 
 */
public class Player implements Play {
    @Override
    public void play(String s) {
        System.out.println(s + s);

    }
}
