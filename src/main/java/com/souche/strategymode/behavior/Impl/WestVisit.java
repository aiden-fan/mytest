package com.souche.strategymode.behavior.Impl;

import com.souche.strategymode.behavior.Read;

/***
 *@author fanmiao
 *@date 2020/3/28 3:23 下午 
 */
public class WestVisit implements Read {
    @Override
    public void read() {
        System.out.println("读西游记");
    }
}
