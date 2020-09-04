package com.souche.invoke;

/***
 *@author fanmiao
 *@date 2020/4/2 3:58 下午 
 */
public class MainTest {
    public static void main(String[] args) {
        InvokeHandle invokeHandle = new InvokeHandle();
        Player player = new Player();
        Play s = (Play) invokeHandle.getInvokeHandle(player);
        s.play("2324");
        System.out.println("s1+");
    }
}
