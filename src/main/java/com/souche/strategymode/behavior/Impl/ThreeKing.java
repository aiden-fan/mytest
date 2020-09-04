package com.souche.strategymode.behavior.Impl;

import com.souche.strategymode.behavior.Read;

/***
 *@author fanmiao
 *@date 2020/3/28 3:21 下午 
 */
public class ThreeKing implements Read {
    @Override
    public void read() {
        System.out.println("读三国演义");
    }
}
