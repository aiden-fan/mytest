package com.souche;

/***
 *@author fanmiao
 *@date 2020/8/19 11:19 上午 
 */
public class JVMTest {
    public static void main(String[] args){
        byte[] b1,b2,b3,b4;//定义变量
        b1=new byte[1024*1024];//分配 1MB 堆空间，考察堆空间的使用情况
        b2=new byte[1024*1024];
        b3=new byte[1024*1024];
        b4=new byte[1024*1024];
    }
}
